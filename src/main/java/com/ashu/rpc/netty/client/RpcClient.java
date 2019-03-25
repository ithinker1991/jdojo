package com.ashu.rpc.netty.client;


import com.ashu.rpc.HiService;

public class RpcClient {
    public static final String providerName = "HiService#hello#";

    public static void main(String[] args) throws InterruptedException {
        RpcConsumer consumer = new RpcConsumer();
        HiService serviceProxy = (HiService) consumer.createProxy(HiService.class, providerName);
        for (; ; ) {
            Thread.sleep(1000);
            System.out.println(serviceProxy.hello("are you ok ?"));
        }
    }

}
