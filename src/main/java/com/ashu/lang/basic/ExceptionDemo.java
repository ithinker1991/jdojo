package com.ashu.lang.basic;

public class ExceptionDemo {

    private static boolean isPowerOfTwo(int val) {
      System.out.println(val + " " + -val);
        return (val & -val) == val;
    }

  public static void main(String[] args) {
      System.out.println(isPowerOfTwo(16));
      System.out.println(isPowerOfTwo(10));

      System.out.println(Integer.toBinaryString(16));
      System.out.println(Integer.toBinaryString(-16));
      System.out.println(-16 & 16);

      System.out.println(Integer.toBinaryString(10));
      System.out.println(Integer.toBinaryString(-10));
      System.out.println(-10 & 10);

  }

}
