package com.atguigu.designpattern.factory.factorymethod.pizzastore.order;

import com.atguigu.designpattern.factory.factorymethod.pizzastore.pizza.*;
import com.atguigu.designpattern.factory.simplefactory.pizzastore.pizza.GreekPizza;

public class LDOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("greek")) {
            pizza = new LDGreekPizza();
        } else if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        }
        return pizza;
    }
}
