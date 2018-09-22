package com.ashu.designpattern.factorymethod;

public class OtherStylePizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        switch (type) {
            case "cheese":
                return new OtherCheesePizza();
            case "clam":
                return new OtherClamPizza();
            default:
                return null;
        }
    }
}
