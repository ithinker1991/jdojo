package com.ashu.designpattern.factorymethod;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        Pizza nyPizza = nyStore.orderPizza("cheese");
        System.out.println("ordered a pizza: " + nyPizza);

        PizzaStore otherPizzaStore = new OtherStylePizzaStore();
        Pizza otherCheesePizza = otherPizzaStore.orderPizza("cheese");
        System.out.println("ordered a pizza: " + otherCheesePizza);
    }
}
