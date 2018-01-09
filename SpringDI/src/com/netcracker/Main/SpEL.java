package com.netcracker.Main;

import com.netcracker.TestClasses.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpEL {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-SpEL.xml");
        Person person = (Person)context.getBean("Person");
    }
}
