package cn.ksdshpx.interview.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/20
 * Time: 14:27
 * Description:StreamAPI之归约与收集
 */
public class TestStreamAPI5 {
    List<Employee> emps = Arrays.asList(
            new Employee("zhangSan", 30, 6666.88, Employee.Status.FREE),
            new Employee("liSi", 45, 7943.99, Employee.Status.BUSY),
            new Employee("wangWu", 18, 2333.90, Employee.Status.VOCATION),
            new Employee("zhaoLiu", 88, 1900.88, Employee.Status.BUSY),
            new Employee("zhaoLiu", 88, 1900.88, Employee.Status.BUSY),
            new Employee("zhaoLiu", 88, 1900.88, Employee.Status.BUSY),
            new Employee("tianQi", 38, 3440.85, Employee.Status.FREE)
    );

    /*
     * 归约：
     * reduce(T identity,BinaryOperator)/reduce(BinaryOperator):可以
     * 将流中元素反复结合起来，得到一个值
     */
    @Test
    public void test01() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);
        System.out.println("=================");
        Optional<Double> salarySum = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(salarySum.get());
    }

    /*
     * 收集:
     * collect:将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void test02() {
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("=============");
        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);
        System.out.println("===============");
        HashSet<String> hashSet = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);
    }

    @Test
    public void test03() {
        //总数
        Long count = emps.stream()
                .collect(Collectors.counting());
        System.out.println(count);
        System.out.println("============");
        //平均值
        Double avgSalary = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avgSalary);
        System.out.println("=============");
        //总和
        Double sumSalary = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sumSalary);
        System.out.println("=============");
        //最大值
        Optional<Employee> max = emps.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());
        //最小值
        Optional<Employee> min = emps.stream()
                .collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(min.get());
    }

    //分组
    @Test
    public void test04() {
        Map<Employee.Status, List<Employee>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    //多级分组
    @Test
    public void test05() {
        Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() < 30) {
                        return "青年";
                    } else if (e.getAge() < 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(map);
    }

    //分区
    @Test
    public void test06() {
        Map<Boolean, List<Employee>> map = emps.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 6000));
        System.out.println(map);
    }

    @Test
    public void test07() {
        DoubleSummaryStatistics dss = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        long count = dss.getCount();
        double average = dss.getAverage();
        double max = dss.getMax();
        double min = dss.getMin();
        double sum = dss.getSum();
        System.out.println("count:" + count + ",average:" + average + ",max:" + max + ",min:" + min + ",sum:" + sum);
    }

    //连接
    @Test
    public void test08(){
        String str = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(str);
    }
}
