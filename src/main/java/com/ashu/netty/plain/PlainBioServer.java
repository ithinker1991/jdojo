package com.ashu.netty.plain;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import org.spongycastle.util.encoders.Hex;

public class PlainBioServer {

  public static void main(String[] args) {
    byte[] temp = Longs.toByteArray(-1);
    System.out.println(temp.length);
    byte[] salt = new byte[32];
    System.arraycopy(temp, 0, salt, 24, 8);

    System.out.println(Hex.toHexString(salt));
  }

}
