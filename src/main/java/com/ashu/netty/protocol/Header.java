package com.ashu.netty.protocol;

public class Header {
    private long sessionID;

    public byte getType() {
        return type;
    }

    private byte type;

    public void setType(byte type) {
        this.type = type;
    }

    public void setSessionID(long sessionID) {

        this.sessionID = sessionID;
    }

    public long getSessionID() {
        return sessionID;
    }
}
