package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/15
 * Time: 21:52
 * Description:模拟银行叫号
 */
public class TicketSaleByRunnable implements Runnable{
    private int saledTicket = 1;
    private final int TICKET_MAX_COUNT = 50;
    @Override
    public void run() {
        while(saledTicket <= 50){
            System.out.println(Thread.currentThread().getName() + ":"+(saledTicket++));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
