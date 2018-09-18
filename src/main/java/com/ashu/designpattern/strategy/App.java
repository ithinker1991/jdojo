package com.ashu.designpattern.strategy;

import com.google.common.collect.Lists;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Duck[] ducks = {new RubberDuck(), new RubberDuck()};

        for (Duck duck: ducks) {
            System.out.println("------------");
            duck.display();
            duck.fly();
            duck.quack();
            duck.swim();
        }
    }
}
