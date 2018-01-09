package com.netcracker.Main;

import com.netcracker.TestClasses.Collection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionSI {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-collection-SI.xml");
        Collection collection = (Collection) context.getBean("Collection");
    }
}
