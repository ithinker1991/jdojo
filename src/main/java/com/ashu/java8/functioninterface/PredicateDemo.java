package com.ashu.java8.functioninterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(1,2 ,3 ,4 ,5 ,6, 7);
    eval(list, integer -> integer > 4);
    eval(list, integer -> integer % 2 == 0);

    Predicate<Integer> p = (integer -> integer > 1);

    System.out.println("custom predicate");
    eval(list, p);
  }



  private static void eval(List<Integer> list, Predicate<Integer> predicate) {
    for (int i: list) {
      if (predicate.test(i)) {
        System.out.println(i + " match rule");
      } else {
        System.out.println(i + " not match rule");
      }
    }
  }
}
