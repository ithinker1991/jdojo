package com.ashu.designpattern.simplefactory.model;

import java.util.List;

public  abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings;

    public void prepare() {
        System.out.println("prepare");
    }

    public void bake() {
        System.out.println("bake");
    }
}
