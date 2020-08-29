package com.ym.learn.demo.oomproblem;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 元数据区溢出
 * 元数据区域也称为方法区，存储着类的相关信息，常量池，常量，方法描述符，字段描述符
 * 运行时产生大量的类就会造成这个区域的溢出
 * 我们运行的时候指定一下元数据区域的大小
 * 参数为  -XX:MetaspaceSize   -XX:MaxMetaspaceSize
 * java.lang.OutOfMemoryError: Metaspace  运行后出现的错误
 * 运行结果说明元数据信息溢出了。这种情况产生的原因有：通过CGLIB大量生成类，导致Meta信息满了
 * 可以调整元数据空间的大小，如果出现了这种异常，如果还是解决不了，只能是排查出现的原因
 */
public class MetaspaceOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(objects,args);
                }
            });
            enhancer.create();
        }
    }
}
