package com.ashu.netty.protocol;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class Server {

    private int port;
    public Server(int port) {
        this.port = port;
    }

    public void start() {
        EventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(group, group)
                .channel((Class<? extends ServerChannel>) NioSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 100)
                .handler(new PrivateChannelInitializer())
        .localAddress(new InetSocketAddress(this.port));
    }

    public static void main(String[] args) {
        int port = 20001;
        new Server(port).start();
    }
}
