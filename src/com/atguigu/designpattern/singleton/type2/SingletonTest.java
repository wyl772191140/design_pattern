package com.atguigu.designpattern.singleton.type2;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

/**
 * 二.饿汉式（静态代码块）
 * 步骤：
 *      1、构造器私有化（防止new）
 *      2、类的内部创建静态代码块完成实例化
 *      3、向外暴露一个静态的公共方法：getInstance
 *  优缺点说明：
 *      这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块 中，也是在类装载的时候，
 *      就执行静态代码块中的代码，初始化类的实例。优缺点和上面（饿汉式（静态常量））是一样的
 *
 *      结论：这种单例模式可用，可能造成内存的浪费。
 */
class Singleton {
    //1.构造器私有化（防止new）
    private Singleton() {

    }

    //2.类的内部创建静态代码块
    private static Singleton instance = null;

    static {
        instance = new Singleton();
    }

    //3.向外暴露一个静态的公共方法
    public static Singleton getInstance() {
        return instance;
    }
}
