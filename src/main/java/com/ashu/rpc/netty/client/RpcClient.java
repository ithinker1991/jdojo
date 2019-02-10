package com.ashu.rpc.netty.client;


import com.ashu.rpc.netty.service.HelloService;

public class RpcClient {
    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) throws InterruptedException {
        RpcConsumer consumer = new RpcConsumer();
        HelloService serviceProxy = consumer.createProxy(HelloService.class, providerName);
        for (; ; ) {
            Thread.sleep(1000);
            System.out.println(serviceProxy.hello("are you ok ?"));
        }
    }

}
