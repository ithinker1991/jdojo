package com.ashu.spring.xml.basic;

import com.ashu.spring.annotation.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessagePrinter {


    private HelloService service;


    @Autowired
    @Qualifier("serviceImpl")
    private HelloServiceImpl helloService;

    private String message;


    private MessagePrinter() {}

    public MessagePrinter(HelloService service, String message) {
        this.service = service;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setService(HelloService service) {
        this.service = service;
    }

    public void hello() {
        System.out.println("hello :" + this.message);
        System.out.println(service.Hello());
        System.out.println(helloService.Hello());
    }
}
