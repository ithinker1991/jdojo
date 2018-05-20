package com.ashu.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {


  @Override
  protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
    System.out.println("Client recived: " + msg.toString());
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
//    System.out.println("connected");
//    ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rock", CharsetUtil.UTF_8));
    ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!",
        CharsetUtil.UTF_8));
  }
}
