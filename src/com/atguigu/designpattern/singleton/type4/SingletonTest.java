package com.atguigu.designpattern.singleton.type4;

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
 * 四、懒汉式（线程安全,同步方法）
 *  步骤：
 *      1、构造方法私有化（防止new）
 *      2、声明静态类的对象（不直接new）
 *      3、向外暴露一个静态的同步公共方法：getInstance，完成对象的实例化
 *
 *   优缺点说明：
 *      1）优点：解决了线程不安全问题。
 *      2）缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance方法，都要进行同步。而其实这个方法只执行一次实例化代码就够了，
 *             后面想获得该类的实例，直接return就行了，方法进行同步效率太低
 *      3）结论：在实际开发中，不推荐使用这种方式
 */
class Singleton{

    private Singleton() {

    }
    private static Singleton instance;

    // 加入了同步代码，解决线程不安全问题，饿汉式
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
