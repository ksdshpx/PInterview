package cn.ksdshpx.interview.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2020/1/13
 * Time: 13:11
 * Description:CAS
 * 1.CAS是什么？==>compareAndSet
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        //main do things...
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data:" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data:" + atomicInteger.get());
    }
}
