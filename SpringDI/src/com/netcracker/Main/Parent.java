package com.netcracker.Main;

import com.netcracker.TestClasses.Apple;
import com.netcracker.TestClasses.Fruit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Parent {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-parent.xml");
        Fruit apple = (Apple)context.getBean("Apple");
    }
}
