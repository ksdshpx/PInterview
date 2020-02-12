package cn.ksdshpx.interview.jvm;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/2/12
 * Time: 10:46
 * Description:<clinit>类构造器测试
 */
public class ClinitTest {
    private int a = 1;

    private static int c = 3;

    public ClinitTest(){
        a = 10;
        int d = 30;
    }

    public static void main(String[] args) {
        int b = 2;
    }
}
