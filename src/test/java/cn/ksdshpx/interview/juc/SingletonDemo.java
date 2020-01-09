package cn.ksdshpx.interview.juc;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2020/1/9
 * Time: 12:45
 * Description:volatile在单例模式中的使用
 */
public class SingletonDemo {
    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造函数");
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        //System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        //System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
