package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/21
 * Time: 10:38
 * Description:结束线程的几种方式-共享变量的方式
 */
public class ThreadStopDemo {
    private static class Worker extends Thread {
        private volatile boolean flag = false;

        @Override
        public void run() {
            while (!flag) {

            }
        }

        private void shutdown() {
            this.flag = true;
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.shutdown();
    }
}
