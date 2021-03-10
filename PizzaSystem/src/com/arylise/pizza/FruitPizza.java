package com.arylise.pizza;

import java.util.Scanner;

public class FruitPizza extends PizzaFactory {
    private String fruits;

    public FruitPizza() {

    }

    private FruitPizza getFruits() {
        System.out.println("配料水果：" + fruits);
        return this;
    }

    private FruitPizza setFruits(String fruits) {
        this.fruits = fruits;
        return this;
    }

    @Override
    public FruitPizza getPizza() {
        return ((FruitPizza) super.getPizza())
                        .getFruits();
    }


    public FruitPizza setPizza() {
        Scanner input = new Scanner(System.in);
        System.out.print("水果种类：");
        String in = input.nextLine();
        return ((FruitPizza) super.setPizza(PizzaType.FRUIT_PIZZA)).setFruits(in);
    }

}
