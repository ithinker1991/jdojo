package com.ashu.third;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFliterDemo {
  public static void main(String[] args) throws InterruptedException {


    int ntransPerBlock = 1000;
    int tps = 500;
//    int nTransPerDay = (24 * 60 * 60) / nSec * ntransPerBlock;
    long nTransPerDay = 24 * 60 * 60 * 300;
    System.out.println(nTransPerDay);
    System.out.println(nTransPerDay / 8 / 1024 / 2014 + "MB");

    long nTransPerYear = nTransPerDay * 365;
    System.out.println(nTransPerYear);
    long i = 10000000;
    BloomFilter<byte[]> filter = BloomFilter.create(Funnels.byteArrayFunnel(), i, 0.01);

    System.out.println("trans per year:" + nTransPerYear);

    long nBytePerYear = nTransPerYear / 8;

    System.out.println("byte per year" + nBytePerYear);

    long nMB = nBytePerYear / 1024;

    System.out.println(nMB + "MB");

    System.out.println(nMB / 1024 + "G");

    while(true) {
      Thread.sleep(50000);
    }



  }

}
