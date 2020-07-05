package com.ym.learn.demo.function;

import java.util.function.Supplier;

public class SupplyDemo {
    public static void main(String[] args) {
        Supplier supplier = () ->{return 1024;};
        System.out.println(supplier.get());
    }
}
