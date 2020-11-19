package com.atguigu.designpattern.singleton.type5;

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
 * 五、懒汉式（线程安全,同步代码块）
 *  步骤：
 *      1、构造方法私有化（防止new）
 *      2、声明静态类的对象（不直接new）
 *      3、向外暴露一个静态的公共方法：getInstance，内部判断后添加同步代码块，完成对象的实例化
 *
 *   优缺点说明：
 *      1）这种方式，本意是对第四种方式（饿汉式，同步方法）的改进，因为前面的同步方法效率太低，改为同步产生实例化的代码块。
 *      2）但是这种同步并不能起到线程同步的作用。跟第三种（饿汉式，线程不安全）实现方式遇到的情形一致，假如一个线程进入了if(instance == null)判断
 *      语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
 *      3）结论：在实际开发中，不能使用这种方式
 */
class Singleton{

    private Singleton() {

    }
    private static Singleton instance;

    // 加入了同步代码块，但仍然存在线程不安全问题，饿汉式
    public static  Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
