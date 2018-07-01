package com.ashu.netty.protocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import io.netty.handler.timeout.ReadTimeoutHandler;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Client {
    private static final String LOCAL_IP = "127.0.0.1";
    private static final int LOCAL_PORT = 50051;

    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    EventLoopGroup group = new NioEventLoopGroup();
    public void connect(String host, int port) throws InterruptedException {
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyMessageDecoder( 1024 * 1024, 0, 4));
                            ch.pipeline().addLast(new NettyMessageEncoder());
//                            ch.pipeline().addLast("readTimeoutHandler", new ReadTimeoutHandler(1000));
                            ch.pipeline().addLast("loginHander", new LoginAuthReqHandler());
                            ch.pipeline().addLast("heartBeatHandler", new HeartBeatReqHander());
                        }
                    });

            ChannelFuture future = b.connect(new InetSocketAddress(host, port)).sync();
            future.channel().closeFuture().sync();


        } finally {
           executor.execute(new Runnable() {
               @Override
               public void run() {
                   try {
                       TimeUnit.SECONDS.sleep(5);
                       try {
                           connect(host, port);
                       } catch (Exception e) {
                           e.printStackTrace();
                       }
//                       connect(port, host);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           });
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String host = "0.0.0.0";
        int port = 20001;
        new Client().connect(host, port);
    }
}
