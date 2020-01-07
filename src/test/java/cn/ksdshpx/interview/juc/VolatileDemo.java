package cn.ksdshpx.interview.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2020/1/7
 * Time: 10:01
 * Description:volatile可见性的代码验证
 */
class MyData {
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }

    //请注意，此时number前面是加了volatile关键字修饰的，volatile不保证原子性
    public void addPlusPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1.验证volatile的可见性
 * 1.1假如int number = 0;number变量之前根本没有添加volatile关键字修饰,没有可见性
 * 1.2添加了volatile，可以解决可见性问题
 * <p>
 * 2.验证volatile不保证原子性
 * 2.1原子性指的是什么意思？
 * 不可分割，完整性，也即某个线程正在做某个业务的时候，中间不可以被加塞或者被分割，需要整体完整，
 * 要么同时成功，要么同时失败。
 * 2.2volatile不保证原子性的案例演示
 * 2.3why
 * 2.4如何解决原子性
 *    *加synchronized锁
 *    *使用juc下的AtomicInteger
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData data = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000 ; j++) {
                    data.addPlusPlus();
                    data.addAtomic();
                }
            }, String.valueOf(i)).start();
        }
        //需要等待上面20个线程都全部计算完成后，再用main线程取得最终的结果值看是多少？
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\tint type,finally number value:" + data.number);
        System.out.println(Thread.currentThread().getName() + "\tatomicInteger type,finally number value:" + data.atomicInteger);
    }

    //volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
    private static void seeOkByVolatile() {
        MyData data = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number value" + data.number);
        }, "AAA").start();

        //第二个线程是main线程
        while (data.number == 0) {
            //main线程就一直在这里等待循环，直到number值不在等于0
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over,main get number value:" + data.number);
    }
}
