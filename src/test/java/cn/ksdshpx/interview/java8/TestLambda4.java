package cn.ksdshpx.interview.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/13
 * Time: 10:56
 * Description:Java8内置的四大核心函数式接口
 *      ①Consumer<T>:消费型接口
 *          void accept(T t);
 *
 *      ②Supplier<T>:供给型接口
 *          T get();
 *
 *      ③Function<T,R>:函数型接口
 *          R apply(T t);
 *
 *      ④Predicate<T>:断言型接口
 *          boolean test(T t);
 */
public class TestLambda4 {
    //Consumer<T>:消费型接口
    @Test
    public void test01(){
        happy(10000.0,(x) -> System.out.println("双十一花费了："+x+"元"));
    }

    public void happy(Double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    //Supplier<T>:供给型接口
    @Test
    public void test02(){
        List<Integer> list = getNumList(10,()-> (int)(Math.random()*100));
        list.forEach(System.out::println);
    }

    //需求:产生指定个数的整数，并放入集合中
    public List<Integer> getNumList(int count, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    //Function<T,R>:函数型接口
    @Test
    public void test03(){
        String result = strHandler("abcDe", (str) -> str.toUpperCase());
        System.out.println(result);
    }

    //需求:用于处理字符串
    public String strHandler(String str, Function<String,String> function){
        return function.apply(str);
    }

    //Predicate<T>:断言型接口
    @Test
    public void test04(){
        List<String> list = Arrays.asList("Hello","Lambda","Bai","OK","NIHAO");
        List<String> result = filterStr(list, (str) -> str.length() > 3);
        result.forEach(System.out::println);
    }

    //需求:将满足条件的字符串添加到集合中并返回
    public List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> result = new ArrayList<>();
        for (String str : list) {
            if (predicate.test(str)){
                result.add(str);
            }
        }
        return result;
    }
}
