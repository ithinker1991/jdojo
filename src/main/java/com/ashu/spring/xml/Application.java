package com.ashu.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        MessagePrinter printer = (MessagePrinter) ctx.getBean("printer");
        printer.hello();



    }
}
