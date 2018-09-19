package com.ashu.designpattern.state;

import java.sql.Statement;

public class Off implements State {
    StatMaine statMaine;
    public Off(StatMaine statMaine) {
        this.statMaine = statMaine;
    }

    @Override
    public void switchOn() {
        System.out.println("switch to on");
    }

    @Override
    public void switchOff() {
        System.out.println("has been off");
        statMaine.setState(statMaine.getOn());
    }
}
