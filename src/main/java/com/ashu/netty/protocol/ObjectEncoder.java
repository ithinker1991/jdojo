package com.ashu.netty.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;

import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.serial.SerialMarshallerFactory;

import java.io.IOException;

public class ObjectEncoder {
    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
    Marshaller marshaller;

    public ObjectEncoder() throws IOException {

        SerialMarshallerFactory factory = new SerialMarshallerFactory();
        MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        UnmarshallerProvider provider = new DefaultUnmarshallerProvider(factory, configuration);
        marshaller = factory.createMarshaller(configuration);

    }

    protected void encode(Object msg, ByteBuf out) throws Exception {
        try {
            //1. 获取写入位置
            int lengthPos = out.writerIndex();
            //2. 先写入4个bytes，用于记录Object对象编码后长度
            out.writeBytes(LENGTH_PLACEHOLDER);
            //3. 使用代理对象，防止marshaller写完之后关闭byte buf
            ChannelBufferByteOutput output = new ChannelBufferByteOutput(out);
            //4. 开始使用marshaller往bytebuf中编码
            marshaller.start(output);
            marshaller.writeObject(msg);
            //5. 结束编码
            marshaller.finish();
            //6. 设置对象长度
            out.setInt(lengthPos, out.writerIndex() - lengthPos - 4);
        } finally {
            marshaller.close();
        }
    }

}
