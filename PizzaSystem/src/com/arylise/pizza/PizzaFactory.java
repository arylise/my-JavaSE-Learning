package com.arylise.pizza;
import java.util.Scanner;

public abstract class PizzaFactory {
    private PizzaType type;
    private int size;
    private int price;

    public PizzaFactory() {
    }

    private PizzaFactory getType() {
        System.out.println("名称：" + type.getName());
        return this;
    }

    private PizzaFactory getSize() {
        System.out.println("大小：" + size + "寸");
        return this;
    }

    private PizzaFactory getPrice() {
        System.out.println("价格：" + price + "元");
        return this;
    }

    private PizzaFactory setType(PizzaType type) {
        this.type = type;
        return this;
    }

    private PizzaFactory setSize(int size) {
        this.size = size;
        return this;
    }

    private PizzaFactory setPrice(int price) {
        this.price = price;
        return this;
    }

    public PizzaFactory getPizza() {
        return this.getType()
                .getPrice()
                .getSize();
    }

    public PizzaFactory setPizza(PizzaType type) {
        Scanner input = new Scanner(System.in);
        System.out.print("大小：");
        int in = input.nextInt();
        System.out.print("价格：");
        return this.setPrice(in).setSize(input.nextInt()).setType(type);
    }
}
