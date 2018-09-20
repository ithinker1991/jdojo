package com.ashu.designpattern.state;

public class StatMaine {
    State state;
    State off;
    State on;

    public State getOff() {
        return off;
    }

    public State getOn() {
        return on;
    }

    public StatMaine() {
        off = new Off(this);
        on = new On(this);
        state = off;
    }

    public void switchOn() {
        printCurrentState();
        state.switchOn();
    }

    private void printCurrentState() {
        System.out.println("current state:" + state.getClass());
    }

    public void switchOff() {
        printCurrentState();
        state.switchOff();
    }

    public void switchState() {


    }

    public void setState(State state) {
        this.state = state;
    }
}
