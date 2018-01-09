package com.netcracker.Main;

import com.netcracker.TestClasses.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCI {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-CI.xml");
        Car car = (Car) context.getBean("Car");
        car.getEngine().drive();
    }
}
