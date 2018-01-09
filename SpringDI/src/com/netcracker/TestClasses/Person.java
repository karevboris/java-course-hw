package com.netcracker.TestClasses;

public class Person {
    private String name;
    private int age;

    public Person() {
        System.out.println("Person.Person");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }
}
