package cn.ksdshpx.interview.concurrency.chapter01;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/15
 * Time: 21:38
 * Description:模拟窗口卖票
 */
public class TicketSaleByThread extends Thread {
    private String name;

    public TicketSaleByThread(String name) {
        this.name = name;
    }

    private static int saledTicket = 1;
    private static final int TICKET_MAX_COUNT = 50;

    @Override
    public void run() {
        while (saledTicket <= TICKET_MAX_COUNT) {
            System.out.println(name + ":" + (saledTicket++));
        }
    }
}
