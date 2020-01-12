package cn.ksdshpx.interview.jvm;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/1/12
 * Time: 11:41
 * Description:栈的演示
 */
public class Demo1_1 {
    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        method2(1, 2);
    }

    private static int method2(int a, int b) {
        int c = a + b;
        return c;
    }
}
