package com.ym.learn.demo.designpatterns.shangguiguhanshunping.patterns.strategy.pattern;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 策略模式  真正的设计模式
 */
public class Client {
    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.display();
        wildDuck.fly();
        ToyDuck toyDuck = new ToyDuck();
        toyDuck.display();
        toyDuck.fly();
        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.setFlyBehavior(new NoFlyBehavior());
        pekingDuck.setQuackBehavior(new GAGAQuackBehavior());
        pekingDuck.display();
        pekingDuck.fly();
        pekingDuck.quack();


        Integer[] data = {9, 1, 2, 8, 3, 4};
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        Arrays.sort(data,comparator);
        System.out.println(Arrays.toString(data));
    }
}
