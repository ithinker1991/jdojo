
package com.ashu.netty.protocol;

import java.util.HashMap;
import java.util.Map;

public enum MessageType {
  FIRST(0x00),
  LOGIN(0x01);

//  TRX(0x01),
//
//  BLOCK(0x02),
//
//  TRXS(0x03),
//
//  BLOCKS(0x04),
//
//  BLOCKHEADERS(0x05),
//
//  INVENTORY(0x06),
//
//  FETCH_INV_DATA(0x07),
//
//  SYNC_BLOCK_CHAIN(0x08),
//
//  BLOCK_CHAIN_INVENTORY(0x09),
//
//  ITEM_NOT_FOUND(0x10),
//
//  FETCH_BLOCK_HEADERS(0x11),
//
//  BLOCK_INVENTORY(0x12),
//
//  TRX_INVENTORY(0x13),
//
//  P2P_HELLO(0x20),
//
//  P2P_DISCONNECT(0x21),
//
//  P2P_PING(0x22),
//
//  P2P_PONG(0x23),
//
//  DISCOVER_PING(0x30),
//
//  DISCOVER_PONG(0x31),
//
//  DISCOVER_FIND_PEER(0x32),
//
//  DISCOVER_PEERS(0x33),
//
//  LAST(0xFF);

  private final int type;



  private MessageType(int type) {
    this.type = type;
  }

  public byte asByte() {
    return (byte) type;
  }



  @Override
  public String toString() {
    switch (type) {
      case 1:
        return "TRX";
      case 2:
        return "BLOCK";
      case 6:
        return "INVENTORY";
      case 7:
        return "FETCH_INV_DATA";
      case 8:
        return "SYNC_BLOCK_CHAIN";
      case 11:
        return "BLOCK_INVENTORY";
      default:
        break;
    }
    return super.toString();
  }
}


