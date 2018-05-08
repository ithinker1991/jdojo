package com.ashu.spring.xml.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-basic.xml");
        MessagePrinter printer = (MessagePrinter) ctx.getBean("printer_setter");
        printer.hello();

//
        MessagePrinter printerConstructor = (MessagePrinter) ctx.getBean("printer_constructor");
        printerConstructor.hello();



    }
}
