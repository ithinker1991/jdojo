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

    public void setHeader(Header header) {
        this.header = header;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
