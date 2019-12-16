package cn.ksdshpx.interview.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/16
 * Time: 15:03
 * Description:Stream API
 *      一、Stream API的三个操作步骤
 *          1.创建Stream
 *          2.中间操作
 *          3.终止操作
 */
public class TestStreamAPI {

    //创建Stream
    @Test
    public void test() {
        //1.通过Collection系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2.通过Arrays中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3.通过Stream中的静态方法of()
        Stream<String> stream3 = Stream.of("a", "b", "c");

        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
    }
}
