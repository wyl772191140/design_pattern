package com.atguigu.designpattern.factory.factorymethod.pizzastore.order;

import com.atguigu.designpattern.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
import com.atguigu.designpattern.factory.factorymethod.pizzastore.pizza.BJGreekPizza;
import com.atguigu.designpattern.factory.factorymethod.pizzastore.pizza.Pizza;

public class BJOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("greek")) {
            pizza = new BJGreekPizza();
        } else if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        }
        return pizza;
    }
}
