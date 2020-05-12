package cn.ksdshpx.interview.jvm;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/1/31
 * Time: 17:04
 * Description:体会invokedynamic指令
 */
@FunctionalInterface
interface Func {
    public boolean func(String str);
}

public class Lambda {
    public void lambda(Func func) {
        return;
    }

    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        Func func = (s) -> {
            return true;
        };
        lambda.lambda(func);
        lambda.lambda((s) -> {
            return true;
        });
    }
}
