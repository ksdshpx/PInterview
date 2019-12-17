package cn.ksdshpx.interview.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/17
 * Time: 14:34
 * Description:Stream的筛选与切片
 *      1.filter:接收一个Lambda，从流中排除某些元素
 *      2.limit:截断流，使其元素不超过给定数量
 *      3.skip(n):跳过元素，返回一个扔掉了前n个元素的流，若流中元素不满n个，则返回一个空流，与limit(n)互补
 *      4.distinct:筛选，通过流所生成的元素hashCode()和equals()方法去除重复元素
 */
public class TestStreamAPI2 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77)
    );
    //内部迭代:迭代操作由Stream API内部完成
    @Test
    public void test01(){
        //中间操作:不会执行任何操作
        Stream<Employee> stream = employees.stream().filter((e) -> {
            System.out.println("中间操作");
            return e.getAge() > 35;
        });
        //终止操作:一次性执行全部内容,即惰性求值
        stream.forEach(System.out::println);
    }

    @Test
    public void test02(){
        employees.stream()
                .filter((e) ->{
                    System.out.println("短路");
                    return e.getSalary() > 5000;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void test03(){
        employees.stream()
                .filter((e) -> e.getSalary() > 5000)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }
}
