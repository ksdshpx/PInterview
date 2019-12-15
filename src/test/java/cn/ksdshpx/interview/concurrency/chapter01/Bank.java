package cn.ksdshpx.interview.concurrency.chapter01;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/15
 * Time: 21:47
 * Description:模拟银行叫号
 */
public class Bank {
    public static void main(String[] args) {
        /*TicketSaleByThread t1 = new TicketSaleByThread("一号窗口");
        TicketSaleByThread t2 = new TicketSaleByThread("二号窗口");
        TicketSaleByThread t3 = new TicketSaleByThread("三号窗口");
        t1.start();
        t2.start();
        t3.start();*/
        TicketSaleByRunnable ticketSaleByRunnable = new TicketSaleByRunnable();
        new Thread(ticketSaleByRunnable,"一号窗口").start();
        new Thread(ticketSaleByRunnable,"二号窗口").start();
        new Thread(ticketSaleByRunnable,"三号窗口").start();
    }
}
