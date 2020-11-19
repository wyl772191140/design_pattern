package com.atguigu.designpattern.singleton.type6;

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
 * 六、双重检查
 *  步骤：
 *      1、构造方法私有化（防止new）
 *      2、声明静态类的对象（不直接new）
 *      3、向外暴露一个静态的公共方法：getInstance，内部同步代码块前后添加双重判断，完成对象的实例化
 *
 *   优缺点说明：
 *      1）Double-Check概念是多线程开发中常使用到的，如代码中所示，我们进行了两次if(singleton == null)检查，这样就可以保证线程安全了。
 *      2）这样，实例化代码只用执行一次，后面再次访问时，判断if(singleton == null)，直接return实例化对象，也避免的反复进行方法同步。
 *      3）解决了线程安全；实现了延迟加载；效率较高
 *      4）结论：在实际开发中，推荐使用这种单例设计模式
 */
class Singleton {

    // 1。构造器私有化
    private Singleton() {}

    //2.声明私有对象
    private static Singleton instance;

    //3.向外暴露静态公共方法：getInstance，方法内在同步代码块前后双重判断
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
