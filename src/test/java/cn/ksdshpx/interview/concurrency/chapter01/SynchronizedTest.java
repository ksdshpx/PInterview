package cn.ksdshpx.interview.concurrency.chapter01;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/30
 * Time: 21:28
 * Description:使用jconsole,jstack观察锁
 */
public class SynchronizedTest {
    private static final Object MONITOR = new Object();

    public static void main(String[] args) {
        Runnable runnable = () -> {
            synchronized (MONITOR) {
                try {
                    Thread.sleep(200_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
    }
}
