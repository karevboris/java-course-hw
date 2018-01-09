package com.netcracker.Main;

import com.netcracker.TestClasses.Collection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionCI {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-collection-CI.xml");
        Collection collection = (Collection) context.getBean("Collection");
    }
}
