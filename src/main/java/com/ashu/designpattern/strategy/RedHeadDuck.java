package com.ashu.designpattern.strategy;

public class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackbehavior(new Squeak());
    }

    @Override
    public void display() {
        System.out.println("I'am a redhead duck");
    }
}
