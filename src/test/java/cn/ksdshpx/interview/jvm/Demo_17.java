package cn.ksdshpx.interview.jvm;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/1/12
 * Time: 19:07
 * Description:局部变量的线程安全问题
 *          方法内的局部变量是否线程安全？
 *          1.如果方法内部局部变量没有逃离方法的作用访问，它是线程安全的
 *          2.如果是局部变量引用了对象，并逃离了方法的作用范围，需要考虑线程安全问题
 */
public class Demo_17 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(4);
        sb.append(5);
        sb.append(6);
        new Thread(() -> {
            m2(sb);
        }).start();
    }

    //不存在线程安全问题
    public static void m1() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    //存在线程安全问题
    public static void m2(StringBuilder sb) {
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    //存在线程安全问题
    public static StringBuilder m3() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        return sb;
    }
}
