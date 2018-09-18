package com.ashu.designpattern.strategy;

public abstract class Duck {
    FlyBehavior flyBehavior;
    Quackbehavior quackbehavior;


    public abstract void display();

    public void fly() {
        flyBehavior.fly();
    }

    public void quack() {
        quackbehavior.quack();
    }

    public void swim() {
        System.out.println("I can swim");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackbehavior(Quackbehavior quackbehavior) {
        this.quackbehavior = quackbehavior;
    }
}
