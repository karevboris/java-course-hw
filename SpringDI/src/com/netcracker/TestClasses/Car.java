package com.netcracker.TestClasses;

public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
        System.out.println("Car.Car");
    }

    public Engine getEngine() {
        return engine;
    }

}
