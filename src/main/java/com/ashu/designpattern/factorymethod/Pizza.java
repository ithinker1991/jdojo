package com.ashu.designpattern.factorymethod;

import java.util.ArrayList;
import java.util.List;

public  abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings;

    public Pizza() {
        name = "default name";
        dough = "default dough";
        sauce = "default sauce";
        toppings = new ArrayList<>();
    }

    public void prepare() {
        System.out.println("prepare");
    }

    public void bake() {
        System.out.println("bake");
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}
