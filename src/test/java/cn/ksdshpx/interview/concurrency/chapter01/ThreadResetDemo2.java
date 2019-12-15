package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/15
 * Time: 11:57
 * Description:线程复位方式2
 */
public class ThreadResetDemo2 {
    private static int i;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    TimeUnit.SECONDS.sleep(1);//中断一个阻塞状态的线程，线程中断状态会复位
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("i:" + i);
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }
}
