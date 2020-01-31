package cn.ksdshpx.interview.jvm;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/1/31
 * Time: 9:51
 * Description:解析调用中非虚方法、虚方法的测试
 *
 *      invokestatic和invokespecial指令调用的方法称为非虚方法
 */
class Father {
    public Father() {
        System.out.println("father的构造函数");
    }

    public static void showStatic(String str) {
        System.out.println("father " + str);
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("father 普通方法");
    }
}

public class Son extends Father {
    public Son() {
        //invokespecial
        super();
    }

    public Son(int age) {
        //invokespecial
        this();
    }

    //不是重写的父类的方法，因为静态方法不能被重写
    public static void showStatic(String str) {
        System.out.println("son " + str);
    }

    private void showPrivate(String str) {
        System.out.println("son private " + str);
    }

    public void show() {
        //invokestatic
        showStatic("atguigu.com");//son atguigu.com
        //invokestatic
        super.showStatic("good!");//father good!
        //invokespecial
        showPrivate("hello");
        //invokespecial
        super.showCommon();

        //invokevirtual
        showFinal();//因为此方法声明有final,不能被子类重写，所以也认为此方法为非虚方法
        //invokevirtual
        showCommon();//虚方法
        //invokevirtual
        info();//虚方法
        MethodInterface in = null;
        //invokeinterface
        in.methodA();//虚方法
    }

    public void info() {

    }

    public void display(Father f) {
        f.showCommon();
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.show();
    }
}

interface MethodInterface {
    void methodA();
}
