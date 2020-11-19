package com.atguigu.designpattern.factory.factorymethod.pizzastore.pizza;

public class LDGreekPizza extends Pizza{
    @Override
    public void prepare() {
        setName(" 伦敦希腊披萨 ");
        System.out.println(" 伦敦希腊披萨 准备原材料 ");
    }
}
