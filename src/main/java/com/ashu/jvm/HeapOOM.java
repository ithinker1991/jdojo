package com.ashu.jvm;

public class HeapOOM {
  public static int _1M = 1024 * 1024 / 4;
  public static void foo() {
    int[] d = new int[_1M  * 2];
  }
  public static void main(String[] args) {
    foo();
    System.gc();
    System.gc();
    int[] d = new int[_1M  * 2];
//    int[] d = new int[1 ];
//    int[] data1 = new int[1 * 1024 * 1024];
//    int[] data = new int[1 * 1024 * 1024];
  }
}
