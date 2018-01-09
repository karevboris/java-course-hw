package com.netcracker.Main;

import com.netcracker.TestClasses.MyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainFactory {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-factory.xml");
        MyFactory myFactory = (MyFactory)context.getBean("MyFactory");
    }
}
