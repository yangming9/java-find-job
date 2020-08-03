package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.interpreter;

import java.util.HashMap;

/**
 * 抽象类表达式 通过hashmap 键值对  可以获取到变量的值
 */
public abstract class Expression {
    //解释公式和数值  key就是公式（表达式） 参数  abc等这些值   value就是具体的值
    public abstract int interpreter(HashMap<String,Integer> var);
}
