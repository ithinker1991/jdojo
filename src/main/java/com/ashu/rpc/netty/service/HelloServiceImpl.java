package com.ashu.rpc.netty.service;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String msg) {
        return "hello, " + msg;
    }
}
