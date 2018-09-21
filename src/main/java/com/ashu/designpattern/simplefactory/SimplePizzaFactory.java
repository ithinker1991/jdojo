package com.ashu.designpattern.simplefactory;

import com.ashu.designpattern.simplefactory.model.Pizza;

public class SimplePizzaFactory {
    public Pizza createPizza(String type) throws IllegalArgumentException {
        Pizza pizza = null;

        switch (type) {
            case "cheese":
               return new CheesePizza();
            case "clam":
                return new ClamPizza();
            default:
                throw new IllegalArgumentException("illegal pizza type:" + type);
        }
    }
}
