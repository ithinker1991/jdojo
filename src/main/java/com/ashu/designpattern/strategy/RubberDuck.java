package com.ashu.designpattern.strategy;

public class RubberDuck extends Duck{
    public RubberDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackbehavior(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("rubber ");
    }
}