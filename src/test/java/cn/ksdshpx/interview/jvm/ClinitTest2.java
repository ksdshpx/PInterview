package cn.ksdshpx.interview.jvm;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/2/12
 * Time: 11:31
 * Description:类的初始化
 */
public class ClinitTest2 {
    static class Father{
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Son extends Father{
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Son.B);
    }
}
