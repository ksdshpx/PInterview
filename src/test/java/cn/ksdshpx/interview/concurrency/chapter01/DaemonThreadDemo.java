package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/18
 * Time: 21:28
 * Description:守护线程的使用
 */
public class DaemonThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "running");
                try {
                    Thread.sleep(1000_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.setDaemon(true);
        t.start();
        TimeUnit.SECONDS.sleep(50);
        System.out.println(Thread.currentThread().getName());
    }
}
