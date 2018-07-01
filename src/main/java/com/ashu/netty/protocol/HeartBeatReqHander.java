package com.ashu.netty.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import sun.tools.tree.NegativeExpression;

public class HeartBeatReqHander extends ChannelInboundHandlerAdapter {
  private volatile ScheduledFuture<?> heartBeatFuture;

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    NettyMessage message = (NettyMessage) msg;

    if (message.getHeader() != null && message.getHeader().getType() == MessageType.LOGIN_RESP.asByte()) {
      heartBeatFuture = ctx.executor().scheduleAtFixedRate(new HeartBeatTesk(ctx), 0, 5000, TimeUnit.SECONDS);
    } else if (message.getHeader() != null && message.getHeader().getType() == MessageType.HEARTBEAT_RESP.asByte()) {
      System.out.println("recived heartbeat from server");

    }
    else {
      ctx.fireChannelRead(msg);
    }
  }

  private class HeartBeatTesk implements Runnable {
    private ChannelHandlerContext ctx;
    public HeartBeatTesk(ChannelHandlerContext ctx) {
      this.ctx = ctx;
    }

    @Override
    public void run() {
      System.out.println("send heartbeat to server");
      NettyMessage heatBeat = buildHeartBeatMessage();
      ctx.writeAndFlush(heatBeat);
    }
  }

  private NettyMessage buildHeartBeatMessage() {
    NettyMessage message = new NettyMessage();
    Header header = new Header();
    header.setType(MessageType.HEARTBEAT_RESP.asByte());
    message.setHeader(header);
    return message;
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    if (heartBeatFuture != null) {
      heartBeatFuture.cancel(true);
      heartBeatFuture = null;
    }
    ctx.fireExceptionCaught(cause);
  }
}
