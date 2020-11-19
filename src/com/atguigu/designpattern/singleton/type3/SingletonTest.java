package com.atguigu.designpattern.singleton.type3;

import java.sql.SQLOutput;

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
 * 三、懒汉式（线程不安全）
 *  步骤：
 *      1、构造方法私有化（防止new）
 *      2、声明静态类的对象（不直接new）
 *      3、向外暴露一个静态的公共方法：getInstance，完成对象的实例化
 *
 *   优缺点说明：
 *      1）起到了Lazy Loading效果，但是只能在单线程下使用。
 *      2）如果在多线程下，一个线程进入了 if(instance == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生
 *          多个实例，所以，在多线程环境下不可使用这种方式。
 *      3）结论：在实际开发中，不要使用这种方式
 */
class Singleton{

    private Singleton() {

    }
    private static Singleton instance;

    // 当调用getInstance方法时，才创建单例对象，饿汉式
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
