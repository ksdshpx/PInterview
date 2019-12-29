package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/15
 * Time: 21:52
 * Description:模拟银行叫号
 */
public class TicketSaleByRunnable implements Runnable {
    private int saledTicket = 1;
    private final int TICKET_MAX_COUNT = 500;
    private final Object MONITOR = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (MONITOR) {
                if (saledTicket > TICKET_MAX_COUNT) {
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + (saledTicket++));
            }
        }
    }
}
