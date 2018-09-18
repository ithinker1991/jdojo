package com.ashu.designpattern.strategy;

public class Quack implements Quackbehavior {
    @Override
    public void quack() {
        System.out.println("nomal quack");

    }
}
