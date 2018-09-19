package com.ashu.designpattern.state;

public class App {
    public static void main(String[] args) {

        StatMaine sm = new StatMaine();

        sm.switchOff();
        sm.switchOn();
        sm.switchOff();
        sm.switchOff();
    }
}
