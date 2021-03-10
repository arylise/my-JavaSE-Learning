package com.arylise.pizza;

import java.util.Scanner;

public class BaconPizza extends PizzaFactory {
    private int baconWeight;

    public BaconPizza() {

    }

    private BaconPizza getBaconWeight() {
        System.out.println("培根克数：" + baconWeight);
        return this;
    }

    private BaconPizza setBaconWeight(int baconWeight) {
        this.baconWeight = baconWeight;
        return this;
    }

    @Override
    public BaconPizza getPizza() {
        return ((BaconPizza) super.getPizza()).getBaconWeight();
    }


    public BaconPizza setPizza() {
        Scanner input = new Scanner(System.in);
        System.out.print("培根克数：");
        int in = input.nextInt();
        return ((BaconPizza) super.setPizza(PizzaType.BACON_PIZZA)).setBaconWeight(in);
    }
}
