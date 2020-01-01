package cn.ksdshpx.interview.concurrency.chapter01;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/1/1
 * Time: 11:47
 * Description:模拟死锁
 */
public class OtherService {
    private DeadLock deakLock;
    private final Object MONITOR = new Object();

    public void setDeakLock(DeadLock deakLock) {
        this.deakLock = deakLock;
    }

    public void s1() {
        synchronized (MONITOR) {
            System.out.println("s1");
        }
    }

    public void s2() {
        synchronized (MONITOR) {
            deakLock.m2();
        }
    }
}
