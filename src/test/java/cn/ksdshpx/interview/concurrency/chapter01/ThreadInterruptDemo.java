package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/15
 * Time: 11:57
 * Description:线程中断示例
 */
public class ThreadInterruptDemo {
    private static int i;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(i);
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
