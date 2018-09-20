package com.ashu.designpattern.state;

public class On implements State{
    StatMaine statMaine;
    public On(StatMaine statMaine) {
        this.statMaine = statMaine;
    }

    @Override
    public void switchOn() {
        System.out.println("has been on");
    }

    @Override
    public void switchOff() {
        System.out.println("switch to off");
        this.statMaine.setState(statMaine.getOff());
    }
}
