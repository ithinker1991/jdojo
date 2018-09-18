package com.ashu.designpattern.strategy;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.printf("no, i can't fly");
    }
}
