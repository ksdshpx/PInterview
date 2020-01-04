package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/1/4
 * Time: 12:51
 * Description:八锁演示
 * 一个对象里面如果有多个synchronized方法，某一个时刻内，只要一个线程去调用其中的一个synchronized方法了，
 * 其他线程都只能等待，换句话说，某一个时刻内，只能有唯一一个线程去访问这些synchronized方法
 * 锁的是当前对象this,被锁定后，其他的线程都不能进入到当前对象的其他的synchronized方法
 *      1.标准访问，请问先打印邮件还是短信？邮件
 *      2.暂停4秒钟在邮件方法，请问先打印邮件还是短信？邮件
 *
 * 加个普通方法后发现和同步锁无关
 *      3.新增普通sayHello方法，请问先打印邮件还是hello？sayHello
 *
 * 换成两个对象后，不是同一把锁了，情况立刻变化
 *      4.两部手机，请问先打印邮件还是短信？短信
 *
 * 对于静态同步方法，锁是当前类的Class对象
 *      5.两个静态同步方法，同一部手机，请问先打印邮件还是短信？邮件
 *      6.两个静态同步方法，两部部手机，请问先打印邮件还是短信？邮件
 *
 *
 *      7.一个静态同步方法，一个普通同步方法，同一部手机，请问先打印邮件还是短信？短信
 *      8.一个静态同步方法，一个普通同步方法，两部手机，请问先打印邮件还是短信？短信
 */
class Phone {
    public static synchronized void sendEmail() throws Exception {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("****sendEmail");
    }

    public synchronized void sendSMS() throws Exception{
        System.out.println("****sendSMS");
    }

    public void sayHello() throws Exception{
        System.out.println("****sayHello");
    }
}


public class Lock8Demo {
    public static void main(String[] args) throws Exception {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        Thread.sleep(100);
        new Thread(() -> {
            try {
                //phone.sendSMS();
                //phone.sayHello();
                phone2.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
