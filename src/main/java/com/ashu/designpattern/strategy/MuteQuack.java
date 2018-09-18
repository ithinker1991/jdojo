package com.ashu.designpattern.strategy;

public class MuteQuack implements Quackbehavior {
    @Override
    public void quack() {
        System.out.println("do nothings");
    }
}
