package cn.ksdshpx.interview.jvm;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/1/28
 * Time: 18:06
 * Description:动态链接
 */
public class DynamicLinkingTest {
    int num = 10;

    public void methodA() {
        System.out.println("methodA()...");
    }

    public void methodB() {
        System.out.println("methodB()...");
        methodA();
        num++;
    }
}
