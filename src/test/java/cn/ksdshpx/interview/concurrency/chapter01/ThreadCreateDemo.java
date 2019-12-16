package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/16
 * Time: 21:38
 * Description:创建线程示例
 */
public class ThreadCreateDemo {
    public static void main(String[] args) {
        //1.构造方式一
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        t1.start();
        //2.构造方式二
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        t2.start();
        //3.构造方式三
        Thread t3 = new Thread("HAHA") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        t3.start();
        //4.构造方式四
        Thread t4 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "HEIHEI");
        t4.start();
        System.out.println("ThreadGroup:" + t4.getThreadGroup().getName());
        System.out.println("activeCount:" + t4.getThreadGroup().activeCount());
        Thread[] threads = new Thread[t4.getThreadGroup().activeCount()];
        t4.getThreadGroup().enumerate(threads);
        Arrays.asList(threads).forEach(System.out::println);
    }
}
