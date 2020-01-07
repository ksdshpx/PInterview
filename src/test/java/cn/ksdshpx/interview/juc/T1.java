package cn.ksdshpx.interview.juc;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2020/1/7
 * Time: 13:40
 * Description:反编译展示原子性原理
 */
public class T1 {
    volatile int n = 0;

    public void add() {
        n++;
    }
}
