package com.atguigu.designpattern.factory.factorymethod.pizzastore.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 工厂方法模式
 * 看一个新的需求
 * 披萨项目新的需求：客户在点披萨时，可以点不同口味的披萨，比如 北京的奶酪pizza、 北京的胡椒pizza 或者是伦敦的奶酪pizza、伦敦的胡椒pizza。
 * 思路1 使用简单工厂模式，创建不同的简单工厂类，比如BJPizzaSimpleFactory、 LDPizzaSimpleFactory 等等.从当前这个案例来说，也是可以的，但是考虑到项目的 规模，以及软件的可维护性、可扩展性并不是特别好
 * 思路2 使用工厂方法模式
 *
 * 工厂方法模式
 * 工厂方法模式介绍
 *      工厂方法模式设计方案：将披萨项目的实例化功能抽象成抽象方法，在不同的口味点 餐子类中具体实现。
 *      工厂方法模式：定义了一个创建对象的抽象方法，由子类决定要实例化的类。工厂方法模式（OrderPizza）将对象的实例化推迟到子类(LDOrderPizza、BJOrderPizza)
 *
 */
public class PizzaStore {

    public static void main(String[] args) {
        String type = getType();
        if (type.equals("bj")) {
            //创建北京口味的各种Pizza
            new BJOrderPizza();
        } else if (type.equals("ld")) {
            //创建伦敦口味的各种Pizza
            new LDOrderPizza();
        }
    }

    // 写一个方法，可以获取客户希望订购的披萨种类
    private static String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza area:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
