package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/21
 * Time: 8:31
 * Description:线程的中断演示
 */
public class ThreadInterruptTest {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Before:" + t.isInterrupted());
        t.interrupt();
        System.out.println("After:" + t.isInterrupted());
    }
}
