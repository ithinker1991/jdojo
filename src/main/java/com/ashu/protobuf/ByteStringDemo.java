package com.ashu.protobuf;

import com.google.protobuf.ByteString;
import org.apache.commons.codec.binary.Hex;

public class ByteStringDemo {

  public static void main(String[] args) {
    ByteString s1 = ByteString.copyFromUtf8("");
    ByteString s2 = ByteString.EMPTY;


    if (s1.equals(s2)) {
      System.out.println("equals");
    }

    System.out.println(Hex.encodeHexString(s1.toByteArray()));
    System.out.println(Hex.encodeHexString(s2.toByteArray()));
  }

}
