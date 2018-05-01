package com.ashu.spring.annotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {


    final private HelloService service;

    @Autowired
    public MessagePrinter(HelloService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.Hello());
    }
}
