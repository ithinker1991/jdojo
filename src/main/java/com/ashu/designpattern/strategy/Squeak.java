package com.ashu.designpattern.strategy;

public class Squeak implements Quackbehavior {
    @Override
    public void quack() {
        System.out.println("squeak!");
    }
}
