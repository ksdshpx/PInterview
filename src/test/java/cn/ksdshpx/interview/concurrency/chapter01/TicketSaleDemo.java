package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2020/1/2
 * Time: 10:13
 * Description:模拟3个售票员卖30张票
 */
class Ticket {
    private int num = 30;

    public void sale() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            if(num > 0){
                System.out.println(Thread.currentThread().getName() + "卖出第" + (num--) + "张票");
            }
        } finally {
            lock.unlock();
        }
    }
}

public class TicketSaleDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            while (true) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            while (true) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            while (true) {
                ticket.sale();
            }
        }, "C").start();
    }
}
