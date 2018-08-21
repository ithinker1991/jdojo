package com.ashu.netty.protocol;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
<<<<<<< HEAD
=======
import io.netty.channel.socket.SocketChannel;
>>>>>>> 3e3def817252460d28390cc7e95415df7326253e
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.net.InetSocketAddress;

public class Server {

    private int port;
    public Server(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
<<<<<<< HEAD
        b.group(group, group)
                .channel((Class<? extends ServerChannel>) NioServerSocketChannel.class)
=======
        try {
            b.group(group, group)
                .channel(NioServerSocketChannel.class)
>>>>>>> 3e3def817252460d28390cc7e95415df7326253e
                .option(ChannelOption.SO_BACKLOG, 100)
                .localAddress(new InetSocketAddress(this.port))
                .option(ChannelOption.TCP_NODELAY, true)
//                .handler((new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyMessageDecoder(1024 * 1024, 0, 4));
                        ch.pipeline().addLast(new NettyMessageEncoder());
//                        ch.pipeline().addLast("readTimeoutHandler", new ReadTimeoutHandler(1000));
                        ch.pipeline().addLast("loginHander", new LoginAuthRespHandler());
                        ch.pipeline().addLast("heartBeatHandler", new HeartBeatRespHandler());
                    }
                })
            .handler(new LoggingHandler(LogLevel.INFO));

            ChannelFuture f = b.bind().sync();
            f.channel().closeFuture().sync();

        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 20001;
        new Server(port).start();
    }
}
