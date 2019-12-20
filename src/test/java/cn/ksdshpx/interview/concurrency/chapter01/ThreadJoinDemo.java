package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/20
 * Time: 10:31
 * Description:线程的join方法
 */
public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            Optional.of(Thread.currentThread().getName() + "=>start at " + System.currentTimeMillis()).ifPresent(System.out::println);
            Optional.of(Thread.currentThread().getName()).ifPresent(System.out::println);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Optional.of(Thread.currentThread().getName() + "=>done at " + System.currentTimeMillis()).ifPresent(System.out::println);
        }, "Machine1");

        Thread t2 = new Thread(() -> {
            Optional.of(Thread.currentThread().getName() + "=>start at " + System.currentTimeMillis()).ifPresent(System.out::println);
            Optional.of(Thread.currentThread().getName()).ifPresent(System.out::println);
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Optional.of(Thread.currentThread().getName() + "=>done at " + System.currentTimeMillis()).ifPresent(System.out::println);
        }, "Machine2");

        Thread t3 = new Thread(() -> {
            Optional.of(Thread.currentThread().getName() + "=>start at " + System.currentTimeMillis()).ifPresent(System.out::println);
            Optional.of(Thread.currentThread().getName()).ifPresent(System.out::println);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Optional.of(Thread.currentThread().getName() + "=>done at " + System.currentTimeMillis()).ifPresent(System.out::println);
        }, "Machine3");

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        long endTime = System.currentTimeMillis();
        System.out.println("endTime:" + endTime);
    }
}
