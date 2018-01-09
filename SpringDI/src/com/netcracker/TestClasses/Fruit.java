package com.netcracker.TestClasses;

public class Fruit {
    protected int count;

    public Fruit() {
        System.out.println("Fruit.Fruit");
    }

    public Fruit(int count) {
        this.count = count;
        System.out.println("count = " + count);
    }
}
