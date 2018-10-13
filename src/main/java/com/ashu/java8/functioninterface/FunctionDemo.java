package com.ashu.java8.functioninterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import javax.xml.bind.SchemaOutputResolver;
import org.apache.commons.lang3.StringUtils;

public class FunctionDemo {


  public static void main(String[] args) {
    String input1 = "";
    String input2 = "12345";

    System.out.println(validInput(input1, input -> input.isEmpty()? "It is a empty string":input));

    System.out.println(validInput(input2, input -> !StringUtils.isNumeric(input) ? "It is not number": input));
    System.out.println(validInput(input1, input -> StringUtils.isNumeric(input) ? "It is not number": input));
  }

  public static String validInput(String name, Function<String,String> function) {
    return function.apply(name);
  }
}
