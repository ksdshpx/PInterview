package cn.ksdshpx.interview.concurrency.chapter01;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/14
 * Time: 19:26
 * Description:模板方法模式
 */
public abstract class TemplateMethod {
    public final void print(String message){
        System.out.println("##########");
        wrapPrint(message);
        System.out.println("##########");
    }

    protected abstract void wrapPrint(String message);

    public static void main(String[] args) {
        new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+++" + message + "+++");
            }
        }.print("Hello Thread!");

        new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("???" + message + "???");
            }
        }.print("Hello Thread!");
    }
}
