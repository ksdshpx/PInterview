package cn.ksdshpx.interview.jvm;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/2/12
 * Time: 10:30
 * Description:类的初始化
 */
public class ClassInitTest {
    private static int num = 1;

    static {
        num = 2;
        number = 20;
        //System.out.println(number);//报错，非法的前向引用
    }

    private static int number = 10;

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);//2
        System.out.println(ClassInitTest.number);//10
    }
}
