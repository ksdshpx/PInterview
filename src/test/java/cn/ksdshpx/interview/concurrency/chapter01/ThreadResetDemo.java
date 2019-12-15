package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/15
 * Time: 12:03
 * Description:线程的复位
 *      ①Thread.interrupted()
 *      ②InterruptedException()
 */
public class ThreadResetDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Before:"+Thread.currentThread().isInterrupted());
                    Thread.interrupted();//复位=>回到初始状态
                    System.out.println("After:"+Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
