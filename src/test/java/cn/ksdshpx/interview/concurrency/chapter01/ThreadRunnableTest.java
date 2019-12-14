package cn.ksdshpx.interview.concurrency.chapter01;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/14
 * Time: 19:16
 * Description:测试执行哪个run()
 */
public class ThreadRunnableTest {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "==>aaa"),"MyThread") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "==>bbb");
            }
        }.start();
    }
}
