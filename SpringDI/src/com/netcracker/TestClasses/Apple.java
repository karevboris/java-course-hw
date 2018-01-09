package com.netcracker.TestClasses;

public class Apple extends Fruit {
    private String name;

    public Apple() {
        System.out.println("Apple.Apple");
    }

    public Apple(int count, String name) {
        super(count);
        this.name = name;
        System.out.println("Apple.Apple");
        System.out.println("name = " + name);
    }
}
