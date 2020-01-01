package cn.ksdshpx.interview.concurrency.chapter01;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/1/1
 * Time: 11:34
 * Description:死锁程序
 */
public class DeadLock {
    private OtherService otherService;
    private final Object MONITOR = new Object();

    public DeadLock(OtherService otherService) {
        this.otherService = otherService;
    }

    public void m1() {
        synchronized (MONITOR) {
            System.out.println("m1...");
            otherService.s1();
        }
    }

    public void m2() {
        synchronized (MONITOR) {
            System.out.println("m2...");
        }
    }

    public static void main(String[] args) {
        OtherService otherService = new OtherService();
        DeadLock deadLock = new DeadLock(otherService);
        otherService.setDeakLock(deadLock);
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    deadLock.m1();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    otherService.s2();
                }
            }
        }.start();
    }
}
