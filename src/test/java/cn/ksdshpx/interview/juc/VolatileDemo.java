package cn.ksdshpx.interview.juc;

import java.util.concurrent.TimeUnit;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2020/1/7
 * Time: 10:01
 * Description:volatile可见性的代码验证
 */
class MyData {
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }
}

/**
 * 1.验证volatile的可见性
 * 1.1假如int number = 0;number变量之前根本没有添加volatile关键字修饰,没有可见性
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData data = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number value" + data.number);
        }, "AAA").start();

        //第二个线程是main线程
        while (data.number == 0) {
            //main线程就一直在这里等待循环，直到number值不在等于0
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over,main get number value:" + data.number);
    }
}
