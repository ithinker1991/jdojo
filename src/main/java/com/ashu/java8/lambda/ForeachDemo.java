package com.ashu.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class ForeachDemo {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      list.add("item" + i);
    }

    list.forEach(System.out::println);
  }
}
