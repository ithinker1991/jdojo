package com.ashu.rpc;

public class HiServiceImpl implements HiService {
    @Override
    public String hello(String msg) {
        return "hello, " + msg;
    }
}