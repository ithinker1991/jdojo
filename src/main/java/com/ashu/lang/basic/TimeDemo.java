package com.ashu.lang.basic;

public class TimeDemo {

  public static void main(String[] args) {
    for (int i = 0; i < 1000; i++) {
      System.out.println(System.nanoTime() / 1000 );
    }
  }

}
