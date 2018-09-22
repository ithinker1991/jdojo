package com.ashu.designpattern.simplefactory;

import com.ashu.designpattern.simplefactory.model.Pizza;

public class SimplePizzaStore {
    SimplePizzaFactory factory;
    public SimplePizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }
    public Pizza orderPizza(String type) {
        Pizza pizza = factory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        return pizza;
    }
}
