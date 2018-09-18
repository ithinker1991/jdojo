package com.ashu.designpattern.strategy;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.printf("I can use wings");
    }
}
