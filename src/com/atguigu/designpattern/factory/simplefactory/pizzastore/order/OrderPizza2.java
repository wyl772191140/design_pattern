package com.atguigu.designpattern.factory.simplefactory.pizzastore.order;

import com.atguigu.designpattern.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza2 {

    public OrderPizza2() {
        setFactory();
    }
    public void setFactory() {
        do {
            String orderType = getType();
            Pizza pizza = SimpleFactory.createPizza2(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println(" 订购披萨失败 ");
                break;
            }
        }while(true);
    }
    private String getType()  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input pizza 种类:");
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
