package cn.ksdshpx.interview.java8;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/10
 * Time: 15:55
 * Description:
 */
@FunctionalInterface
public interface MyPredicate<T> {
    public boolean test(T t);
}
