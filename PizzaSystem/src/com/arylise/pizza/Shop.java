package com.arylise.pizza;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Ordering:
        while (true) {
            System.out.print("选择pizza类型：1，培根披萨。2，水果披萨。0，取消点餐：");
            int chose = input.nextInt();
            switch (chose) {
                case 0 -> {
                    System.out.println("感谢您的光临，下次再见");
                    break Ordering;
                }
                case 1 -> new BaconPizza().setPizza().getPizza();
                case 2 -> new FruitPizza().setPizza().getPizza();
                default -> System.out.println("请重新输入");
            }
        }
    }
    public static int fun3() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("选择pizza类型：1，培根披萨。2，水果披萨。0，取消点餐：");
        int chose = input.nextInt();
        if (chose == 0) {
            return 0;
        }
        if (chose != 1 && chose != 2) {
            return -1;
        }
        String path = "com.arylise.pizza.";
        path += (chose == 1) ? "BaconPizza" : "FruitPizza";
        Class cls = Class.forName(path);
        Object o = cls.newInstance();
        Method m1 = cls.getMethod("setPizza");
        Method m2 = cls.getMethod("getPizza");
        ((Method) m1).invoke(o);
        m2.invoke(o);
        return 0;
    }
}
