package com.ashu.designpattern.factorymethod;

public class NYStylePizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        switch (type) {
            case "cheese":
                return new NYStyleCheesePizza();
            case "clam":
                return new NYStyleClamPizza();
            default:
                return null;
        }
    }

    private class NYStyleClamPizza extends Pizza {
        public NYStyleClamPizza() {
            name = "NYStyleClamPizza";
            dough = "Thin Crust Dough";
            sauce = "Marinara Sauce";
            toppings.add("Crated Reggiano Cheese");
        }
    }

    private class NYStyleCheesePizza extends Pizza {
        public NYStyleCheesePizza() {
            name = "Cheese Pizza";
            dough = "Cheese Dough";
            sauce = "Cheese Sauce";
            toppings.add("Crated Reggiano Cheese");
        }

    }
}
