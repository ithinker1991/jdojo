package com.ashu.spring.xml.basic;

import com.ashu.spring.annotation.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String Hello() {

        return "Hello world";
    }
}
