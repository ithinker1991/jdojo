package com.ashu.designpattern.factorymethod;

public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        return pizza;
    }
    abstract Pizza createPizza(String type);
}
