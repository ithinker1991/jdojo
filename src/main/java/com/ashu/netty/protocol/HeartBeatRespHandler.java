package com.ashu.netty.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HeartBeatRespHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    NettyMessage message = (NettyMessage)msg;
    if (message.getHeader() != null && message.getHeader().getType() == MessageType.HEARTBEAT.asByte()) {
      System.out.println("recived heartbeat from " + ctx.channel().remoteAddress());
      NettyMessage heartBeatResp = buildHeartResp();
      ctx.writeAndFlush(heartBeatResp);

    } else {
      ctx.fireChannelRead(msg);
    }
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    ctx.fireExceptionCaught(cause);
  }

  private NettyMessage buildHeartResp() {
    NettyMessage message = new NettyMessage();
    Header header = new Header();
    header.setType(MessageType.HEARTBEAT_RESP.asByte());
    message.setHeader(header);
    return message;
  }


}
