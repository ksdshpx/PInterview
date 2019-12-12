package cn.ksdshpx.interview.java8;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/12
 * Time: 14:21
 * Description:函数式接口
 */
@FunctionalInterface
public interface MyFunction2<T,R> {
    R getValue(T t1,T t2);
}
