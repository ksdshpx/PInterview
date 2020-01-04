package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/1/3
 * Time: 21:32
 * Description:集合不安全
 *      1.故障现象
 *          java.util.ConcurrentModificationException
 *      2.导致原因
 *      3.解决方案
 *          3.1 new Vector<>()
 *          3.2 Collections.synchronizedList(new ArrayList<>())
 *          3.3 new CopyOnWriteArrayList<>()
 *      4.优化建议
 */
public class NotSafeDemo {
    public static void main(String[] args) {
        setNotSafe();
    }

    private static void setNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    private static void listNotSafe() {
        List<String> list = new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>());//new Vector<>();//new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
