package com.ashu.netty.protocol;

public class Header {
    private long sessionID;

    public byte getType() {
        return type;
    }

    private byte type;

    public long getSessionID() {
        return sessionID;
    }
}
