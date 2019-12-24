package cn.ksdshpx.interview.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/24
 * Time: 14:19
 * Description:StreamAPI练习
 */
public class TestStreamAPI6 {
    /**
     * 1.给定一个数字列表，如何返回一个由每个数的平方构成的列表？
     * 给定[1,2,3,4,5],应该返回[1,4,9,16,25]
     */
    @Test
    public void test01() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        nums.stream()
                .map((e) -> e * e)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 2.怎样用map和reduce方法数一数流中共有多少个Employee对象
     */
    List<Employee> emps = Arrays.asList(
            new Employee("zhangSan", 30, 6666.88),
            new Employee("liSi", 45, 7943.99),
            new Employee("wangWu", 18, 2333.90),
            new Employee("zhaoLiu", 88, 1900.88),
            new Employee("tianQi", 38, 3440.85),
            new Employee("tianQi", 38, 3440.85),
            new Employee("tianQi", 38, 3440.85)
    );

    @Test
    public void test02() {
        Integer count = emps.stream()
                .map((e) -> 1)
                .reduce(0, (x, y) -> x + y);
        System.out.println(count);
    }
}
