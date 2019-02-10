package com.ashu.rpc.netty.server;

import com.ashu.rpc.netty.service.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HelloServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);
        String result = new HelloServiceImpl().hello(msg.toString());
        ctx.writeAndFlush(result);
    }
}
