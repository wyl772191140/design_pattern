package com.atguigu.designpattern.singleton.type7;

public class SingletonTest {

    public static void main(String[] args) {
        Singleton instanc1 = Singleton.getInstance();
        Singleton instanc2 = Singleton.getInstance();
        System.out.println(instanc1 == instanc2);
        System.out.println(instanc1.hashCode());
        System.out.println(instanc2.hashCode());
    }
}

/**
 * 七、静态内部类，实现单例模式
 * 步骤：
 *      1、构造方法私有化
 *      2、内部提供一个私有静态内部类，内部类中有个外部类的实例，且是静态常量的
 *      3、外部暴露一个静态公共方法：getInstance，直接返回静态内部类的里面的实例
 *  优缺点说明：
 *      1）、这种方式采用了类装载的机制来保证初始化实例时只有一个线程
 *      2）、静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，
 *          从而完成Singleton的实例化。
 *      3）、类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 *      4）、优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高。
 *      5）、结论：推荐使用
 */
class Singleton {

    // 1.构造方法私有化
    private Singleton() {}

    // 2、内部提供一个私有静态内部类，内部类中有个外部类的实例，且是静态常量的
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    // 3、外部暴露一个静态公共方法：getInstance，直接返回静态内部类的里面的实例
    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
