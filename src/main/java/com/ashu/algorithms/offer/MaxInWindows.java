package com.ashu.algorithms.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MaxInWindows {
  public static ArrayList<Integer> maxInWindows(int [] num, int size)
  {
    LinkedList<Character> list = new LinkedList<>();
    Iterator<Character> i = list.iterator();

    ArrayList<Integer> result = new ArrayList<>();
    ArrayDeque<Integer> ll = new ArrayDeque<>();

    int index = 1;
    for (int n : num){

      while (ll.size() >= size) {
        ll.pollFirst();
      }
      ll.removeIf(integer -> integer <= n);
      ll.addLast(n);
      if (index >= size) {
        result.add(ll.peekFirst());
      }
      index++;

    }
    Arrays.asList(result);

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Integer.toBinaryString(Add(11, 899)) + " " + Add(11, 899));
    System.out.println();
    System.out.println(Integer.toBinaryString(11 + 899) + " " + (11 + 899));

  }
  public static int Add(int num1,int num2) {
    System.out.println("num1 = " + Integer.toBinaryString(num1) + " num2=" + Integer.toBinaryString(num2));

    int xor = num1 ^ num2;
    int and = num1 & num2;
    System.out.println("xor = " + Integer.toBinaryString(xor) + " and=" + Integer.toBinaryString(and << 1));
    while (and != 0) {
      int temp = xor ^ (and << 1);
      and = xor & (and << 1);


      xor = temp;
      System.out.println("xor = " + Integer.toBinaryString(xor) + " and=" + Integer.toBinaryString(and << 1));
    }
    return xor;
  }
}
