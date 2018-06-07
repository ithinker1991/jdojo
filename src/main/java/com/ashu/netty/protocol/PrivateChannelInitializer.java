package com.ashu.netty.protocol;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.channels.SocketChannel;

public class PrivateChannelInitializer extends ChannelInitializer<Channel> {


    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline().addLast(new NettyMessageDecoder( 1024 * 1024, 4, 4));
        ch.pipeline().addLast(new NettyMessageEncoder());

    }


//    @Override
//    protected void initChannel(NioSocketChannel ch) throws Exception {
//        ch.pipeline().addLast(new NettyMessageDecoder( 1024 * 1024, 4, 4));
//        ch.pipeline().addLast(new NettyMessageEncoder());
//
//    }
}
