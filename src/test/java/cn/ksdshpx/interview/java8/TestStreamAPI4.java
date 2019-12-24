package cn.ksdshpx.interview.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/19
 * Time: 10:33
 * Description:StreamAPI的终止操作_查找与匹配
 */
public class TestStreamAPI4 {
    List<Employee> emps = Arrays.asList(
            new Employee("zhangSan", 30, 6666.88, Employee.Status.FREE),
            new Employee("liSi", 45, 7943.99, Employee.Status.BUSY),
            new Employee("wangWu", 18, 2333.90, Employee.Status.VOCATION),
            new Employee("zhaoLiu", 88, 1900.88, Employee.Status.BUSY),
            new Employee("zhaoLiu", 88, 1900.88, Employee.Status.BUSY),
            new Employee("zhaoLiu", 88, 1900.88, Employee.Status.BUSY),
            new Employee("tianQi", 38, 3440.85, Employee.Status.FREE)
    );

    /**
     * 1.查找与匹配
     * ①boolean allMatch(Predicate<? super T> predicate):检查是否匹配所有元素
     * ②boolean anyMatch(Predicate<? super T> predicate):检查是否至少匹配一个元素
     * ③boolean noneMatch(Predicate<? super T> predicate:检查是否没有匹配所有元素
     * ④Optional<T> findFirst():返回第一个元素
     * ⑤Optional<T> findAny():返回流中的任意元素
     * ⑥long count():返回流中的元素总个数
     * ⑦Optional<T> max(Comparator<? super T> comparator):返回流中的最大值
     * ⑧Optional<T> min(Comparator<? super T> comparator):返回流中的最小值
     */

    @Test
    public void test01() {
        boolean b = emps.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
        System.out.println("==============");
        b = emps.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
        System.out.println("==============");
        b = emps.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
        System.out.println("===============");
        Optional<Employee> op = emps.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(op.get());
        System.out.println("==============");
        Optional<Employee> op2 = emps.stream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(op2.get());
    }

    @Test
    public void test02() {
        long count = emps.stream()
                .count();
        System.out.println(count);
        System.out.println("===================");
        Optional<Employee> max = emps.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max.get());
        Optional<Double> min = emps.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(min.get());
    }
}
