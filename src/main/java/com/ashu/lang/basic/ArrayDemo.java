package com.ashu.lang.basic;

import java.util.Arrays;

public class ArrayDemo {

  public static void main(String[] args) {

    Integer[] arr = new Integer[2];

    arr[1] = 1;
    arr[0] = 2;

    for (int i: arr) {
      System.out.println(i);
    }

    int[] arr1 = new int[10];

    Arrays.asList(arr1, new Integer[0]);
    System.out.println(Arrays.toString(arr1));
  }

}
