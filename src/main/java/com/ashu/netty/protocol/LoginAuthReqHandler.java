package com.ashu.netty.protocol;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class LoginAuthReqHandler extends ChannelInboundHandlerAdapter {


  public LoginAuthReqHandler() {
    super();
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    ctx.writeAndFlush(buildLoginReq());
    super.channelActive(ctx);
  }

  private NettyMessage buildLoginReq() {
    NettyMessage message = new NettyMessage();
    Header header = new Header();

    header.setType(MessageType.LOGIN.asByte());
    message.setHeader(header);
    return message;
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    NettyMessage message = (NettyMessage) msg;

    if (message.getHeader() != null && message.getHeader().getType() == MessageType.LOGIN.asByte()) {
      byte loginResult = (byte) message.getBody();
      if (loginResult != (byte) 0) {
        ctx.close();
      } else {
        System.out.println("login success: " + message);
        ctx.fireChannelRead(msg);
      }
    } else {
      ctx.fireChannelRead(msg);
    }
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    ctx.fireExceptionCaught(cause);
  }
}
