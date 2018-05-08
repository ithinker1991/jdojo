package com.ashu.spring.xml.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-auto.xml");
        MessagePrinter printerByName = (MessagePrinter) ctx.getBean("printerByName");
        printerByName.hello();

        MessagePrinter printerByType = (MessagePrinter) ctx.getBean("printerByType");
        printerByType.hello();

        MessagePrinter printerByType1 = (MessagePrinter) ctx.getBean("printerByType");

        System.out.println(printerByType);
        System.out.println(printerByType1);
        if (printerByType == printerByType1) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

        MessagePrinter printerByConstructor = (MessagePrinter) ctx.getBean("printerByConstructor");
        printerByConstructor.hello();

    }
}
