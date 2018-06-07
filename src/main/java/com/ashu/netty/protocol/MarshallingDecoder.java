package com.ashu.netty.protocol;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteInput;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;
import org.jboss.marshalling.serial.SerialMarshallerFactory;

import java.io.IOException;

public class MarshallingDecoder {
    private final Unmarshaller unmarshaller;
    public MarshallingDecoder() throws IOException {
        SerialMarshallerFactory factory = new SerialMarshallerFactory();
        MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        unmarshaller = factory.createUnmarshaller(configuration);
    }

    protected Object decode(ByteBuf in) throws ClassNotFoundException, IOException {
        int objectSize = in.readInt();
        ByteBuf buf = in.slice(in.readerIndex(), objectSize);
        ByteInput input = new ChannelBufferByteInput(buf);

        try {
            unmarshaller.start(input);
            Object obj = unmarshaller.readObject();
            unmarshaller.finish();
            in.readerIndex(in.readerIndex() + objectSize);
            return obj;
        } finally {
            unmarshaller.close();
        }
    }

}
