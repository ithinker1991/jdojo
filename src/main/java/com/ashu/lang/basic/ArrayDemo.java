package com.ashu.lang.basic;

public class ArrayDemo {

  public static void main(String[] args) {

    Integer[] arr = new Integer[2];

    arr[1] = 1;
    arr[0] = 2;

    for (int i: arr) {
      System.out.println(i);
    }
  }

}
