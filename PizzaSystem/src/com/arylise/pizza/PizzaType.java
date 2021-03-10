package com.arylise.pizza;

public enum PizzaType {
    BACON_PIZZA("培根披萨", 1), FRUIT_PIZZA("水果披萨", 2);
    private String name;
    private int index;

    private PizzaType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }
}
