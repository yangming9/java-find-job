package com.ym.learn.demo.function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {

        User u1 = new User(1, "a", 23);
        User u2 = new User(2, "b", 24);
        User u3 = new User(3, "c", 25);
        User u4 = new User(4, "d", 26);
        User u5 = new User(5, "e", 27);
        User u6 = new User(6, "f", 28);
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5, u6);

        list.stream().filter(user -> user.getAge() % 2 == 0)
                .filter(user -> user.getAge()>25)
                .map(user -> user.getName().toUpperCase())
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .forEach(System.out::println);

    }
}
