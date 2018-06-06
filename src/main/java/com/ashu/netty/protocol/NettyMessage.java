package com.ashu.netty.protocol;

public class NettyMessage {
    private Header header;
    private Object body;

    public Object getBody() {
        return body;
    }

    public Header getHeader() {

        return header;
    }
}
