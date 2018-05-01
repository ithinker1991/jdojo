package com.ashu.spring.xml;

public class MessagePrinter {


    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void hello() {
        System.out.println("hello :" + this.message);
    }
}
