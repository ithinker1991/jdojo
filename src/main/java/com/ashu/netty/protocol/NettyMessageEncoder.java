package com.ashu.netty.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.marshalling.*;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

import java.io.IOException;
import java.util.List;

public class NettyMessageEncoder extends MessageToByteEncoder<NettyMessage> {
    public MarshallingEncoder marshallingEncoder;
    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];

    public NettyMessageEncoder() throws IOException {
        final MarshallerFactory marshallerFactory = Marshalling.getMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        MarshallerProvider provider = new DefaultMarshallerProvider(
                marshallerFactory, configuration);
        marshallingEncoder = new MarshallingEncoder();
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, NettyMessage msg, ByteBuf out)
        throws Exception {
        if (msg == null || msg.getHeader() == null) {
            throw new Exception("The encode message is null");
        }
//
//        ByteBuf sendBuf = Unpooled.buffer();
//        sendBuf.writeLong(msg.getHeader().getSessionID());
        out.writeBytes(LENGTH_PLACEHOLDER);
        out.writeByte(msg.getHeader().getType());

        if (msg.getBody() != null) {
//            marshallingDecoder.encode(ctx, msg.getBody(), sendBuf);
            marshallingEncoder.encode(msg.getBody(), out);
        } else {
            out.writeInt(0);

        }
        out.setInt(0, out.readableBytes() - 4);
    }
}
