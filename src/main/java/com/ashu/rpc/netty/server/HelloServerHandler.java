package com.ashu.rpc.netty.server;

import com.ashu.rpc.HiServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HelloServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String result = new HiServiceImpl().hello(msg.toString());
        ctx.writeAndFlush(result);
    }
}
