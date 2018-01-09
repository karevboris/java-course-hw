package com.netcracker.Main;

import com.netcracker.TestClasses.Buyer;
import com.netcracker.TestClasses.Operations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LookUp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-lookup.xml");
        Operations operations = (Operations)context.getBean("Operations");
        Buyer buyer = operations.buy();
        System.out.println("buyer = " + buyer);
        Buyer newBuyer = operations.buyVip();
        System.out.println("newBuyer = " + newBuyer);
    }
}
