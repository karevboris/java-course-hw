package com.netcracker.Main;

import com.netcracker.TestClasses.Film;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiringByName {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-autowiring-byName.xml");
        Film film = (Film)context.getBean("Film");
    }
}
