package com.ashu.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionInterfaceDemo {
    public static void main(String[] args) {

//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> list = Arrays.asList(1,2 ,3 ,4 ,5 ,6, 7);

        eval(list, integer -> integer > 4);

        eval(list, integer -> integer % 2 == 0);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (int i: list) {
            if (predicate.test(i)) {
                System.out.printf(i + " match rule");
            }
        }
    }
}
