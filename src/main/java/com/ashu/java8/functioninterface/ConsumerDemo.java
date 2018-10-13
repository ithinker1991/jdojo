package com.ashu.java8.functioninterface;

import java.util.function.Consumer;

public class ConsumerDemo {

  public static void main(String[] args) {

  }

  public static void validInput(String input, Consumer<String> consumer) {
    consumer.accept(input);
  }

}
