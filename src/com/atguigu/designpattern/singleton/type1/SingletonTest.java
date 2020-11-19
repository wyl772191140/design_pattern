package com.atguigu.designpattern.singleton.type1;

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
 * 一、饿汉式（静态常量）
 * 步骤：
 *      1、构造器私有化（防止new）
 *      2、类的内部创建对象
 *      3、向外暴露一个静态的公共方法：getInstance
 *  优缺点说明：
 *      优点：这种写法比较简单，就是在类装载的时候就完成了实例化。避免了线程同步问题（线程还未开始，就已经实例化了，压根就不存在线程安全问题）
 *      缺点：在类装载的时候就完成了实例化，没有达到Lazy loading效果。如果从始至终从未使用过这个实例，则会造成资源的浪费。（这句话对的意思是，正常情况下，
 *          调用这个类的getInstance方法来获取实例对象，达到使用这个类的方式，如果类中存在其他静态公共方法来完成业务逻辑，而并非想要使用这个类的实例，此时就会造成资源的浪费）
 *
 *        这种方式是基于classloader机制避免了多线程同步问题，不过，instance在类装载时就已经实例化，在单例模式中，大多数是调用getInstance方法，但是导致类装载的原因有很多种，
 *        因此，不能确定有其他的方式（或者其他静态方法）导致类装载，这时候初始化instance就没有达到lazy loading效果。
 *
 *      结论：这种单例模式可用，可能造成内存的浪费。
 */
class Singleton{

    //1.构造器私有化（防止new）
    private Singleton() {

    }

    //2.类的内部创建对象
    private static Singleton instance = new Singleton();

    //3.向外暴露一个静态的公共方法
    public static Singleton getInstance() {
        return instance;
    }
}
