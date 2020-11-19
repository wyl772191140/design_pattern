package com.atguigu.designpattern.factory.simplefactory.pizzastore.order;

import com.atguigu.designpattern.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.atguigu.designpattern.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.atguigu.designpattern.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    // 构造器
//    public OrderPizza() {
//        Pizza pizza = null;
//        String orderType = null; //订购披萨类型
//
//        do{
//            orderType = getType();
//            if ("greek".equals(orderType)) {
//                pizza = new GreekPizza();
//                pizza.setName( " 希腊披萨 ");
//            } else if ("cheese".equals(orderType)) {
//                pizza = new CheesePizza();
//                pizza.setName(" 奶酪披萨 ");
//            } else if ("cheese".equals(orderType)) {
//               pizza = new PepperPizza();
//               pizza.setName(" 胡椒披萨 ");
//              }  else {
//                break;
//            }
//            //输出pizza 制作过程
//			pizza.prepare();
//			pizza.bake();
//			pizza.cut();
//			pizza.box();
//        }while(true);
//    }

    //定义一个简单工厂对象
    private SimpleFactory simpleFactory;
    public OrderPizza(SimpleFactory factory) {
        setFactory(factory);
    }
    public void setFactory(SimpleFactory factory) {
        this.simpleFactory = factory;//设置简单工厂对象

        do {
            String orderType = getType();
            Pizza pizza = factory.createPizza(orderType);
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
