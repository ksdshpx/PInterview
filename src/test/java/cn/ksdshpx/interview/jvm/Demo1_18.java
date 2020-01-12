package cn.ksdshpx.interview.jvm;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/1/12
 * Time: 19:00
 * Description:局部变量的线程安全问题
 *      结论:局部变量不存在线程安全问题
 */
public class Demo1_18 {
    //多个线程同时执行此方法
    static void m1() {
        int x = 0;
        for (int i = 0; i < 5000; i++) {
            x++;
        }
        System.out.println(x);
    }
}
