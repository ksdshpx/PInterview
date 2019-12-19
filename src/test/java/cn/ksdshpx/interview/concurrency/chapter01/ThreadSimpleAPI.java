package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.Optional;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/19
 * Time: 21:13
 * Description:Thread类的简单API
 */
public class ThreadSimpleAPI {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Optional.of("Hello").ifPresent(System.out::println);
        }, "t1");
        t.start();
        Optional.of(t.getId()).ifPresent(System.out::println);
        Optional.of(t.getName()).ifPresent(System.out::println);
        Optional.of(t.getPriority()).ifPresent(System.out::println);
    }
}
