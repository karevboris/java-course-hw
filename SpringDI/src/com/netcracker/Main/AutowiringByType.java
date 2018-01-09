package com.netcracker.Main;

import com.netcracker.TestClasses.Film;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiringByType {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-autowiring-byType.xml");
        Film film = (Film)context.getBean("Film");
    }
}
