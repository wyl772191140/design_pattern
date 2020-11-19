package com.atguigu.designpattern.factory.simplefactory.pizzastore.order;

/**
 * 传统的方式的优缺点
 * 1) 优点是比较好理解，简单易操作。
 * 2) 缺点是违反了设计模式的ocp原则，即对扩展开放，对修改关闭。即当我们给类增 加新功能的时候，尽量不修改代码，或者尽可能少修改代码.
 * 3) 比如我们这时要新增加一个Pizza的种类(Pepper披萨)，我们需要做如下修改
 * 4) 改进的思路分析
 * 分析：修改代码可以接受，但是如果我们在其它的地方也有创建Pizza的代码，就意味 着，也需要修改，而创建Pizza的代码(OrderPizza)，往往有多处。
 * 思路：把创建Pizza对象封装到一个类中，这样我们有新的Pizza种类时，只需要修改该 类就可，其它有创建到Pizza对象的代码就不需要修改了.-> 简单工厂模式
 *
 * 简单工厂模式
 * 基本介绍
 * 1) 简单工厂模式是属于创建型模式，是工厂模式的一种。简单工厂模式是由一 个工厂对象决定创建出哪一种产品类的实例。简单工厂模式是工厂模式家族 中最简单实用的模式
 * 2) 简单工厂模式：定义了一个创建对象的类，由这个类来封装实例化对象的行为
 * 3) 在软件开发中，当我们会用到大量的创建某种、某类或者某批对象时，就会 使用到工厂模式
 *
 */
public class PizzaStore {
    public static void main(String[] args) {
//        new OrderPizza();

//          new OrderPizza(new SimpleFactory());

        new OrderPizza2();
    }
}
