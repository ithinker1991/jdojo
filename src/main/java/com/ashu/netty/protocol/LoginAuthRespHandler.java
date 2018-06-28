package com.ashu.netty.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;

import java.util.HashSet;
import java.util.Set;

public class LoginAuthRespHandler extends ChannelInboundHandlerAdapter {

    private Set<String> logedNodes = new HashSet<>();
    private String[] whiteList = {"127.0.0.1", "127.0.0.1"};




    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage) msg;

        if (message.getHeader()  != null && message.getHeader().getType() == MessageType.LOGIN.asByte()) {

            String nodeId = ctx.channel().remoteAddress().toString();
            NettyMessage loginResp = null;
            if (logedNodes.contains(nodeId)) {
                // logined, refused
                loginResp = buildResponse((byte) -1);

            } else {
                boolean ok = false;
                for (String wip: whiteList) {
                    if (wip.equals(nodeId)) {
                        ok = true;
                        break;
                    }
                }

                if (ok) {
                    logedNodes.add(nodeId);
                    loginResp = buildResponse((byte) 0);
                } else {
                    loginResp = buildResponse((byte) -1);
                }
            }

            ctx.writeAndFlush(loginResp);

        } else {
            // 消息穿透
            ctx.fireChannelRead(msg);
        }
    }

    private NettyMessage buildResponse(byte result) {
        NettyMessage message = new NettyMessage();
        Header header = new Header();

        header.setType(MessageType.LOGIN_RESP.asByte());
        message.setHeader(header);
        message.setBody(result);
        return message;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logedNodes.remove(ctx.channel().remoteAddress().toString());
        ctx.close();
        ctx.fireExceptionCaught(cause);
    }
}
