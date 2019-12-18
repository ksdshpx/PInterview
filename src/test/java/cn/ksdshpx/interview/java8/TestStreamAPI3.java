package cn.ksdshpx.interview.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/18
 * Time: 15:40
 * Description:Stream API之映射与排序
 *    映射：
 *      1.map:接收Lambda,将元素转换成其他形式或提取信息。接收一个函数作为参数，
 *            该函数会被应用到每个元素上，并将其映射成一个新的元素
 *      2.flatMap:接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
 *
 *    排序：
 *      1.sort:自然排序
 *      2.sort(Comparator):定制排序
 */
public class TestStreamAPI3 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77)
    );
    @Test
    public void test01(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);
        System.out.println("-----------");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("-----------");
        //{{a,a,a},{b,b,b}}
        Stream<Stream<Character>> stream = list.stream()
                .map(TestStreamAPI3::filterCharacter);
        stream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });
        System.out.println("------------");
        //{a,a,a,b,b,b}
        Stream<Character> flatStream = list.stream()
                .flatMap(TestStreamAPI3::filterCharacter);
        flatStream.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for(Character ch : str.toCharArray()){
            list.add(ch);
        }
        return list.stream();
    }

    @Test
    public void test02(){
        List<String> list = Arrays.asList("ccc","bbb","aaa","ddd","eee");
        list.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("------------");
        employees.stream()
                .sorted((e1,e2) ->{
                    if(e1.getAge().equals(e2.getAge())){
                        return e1.getName().compareTo(e2.getName());
                    }else{
                        return e1.getAge().compareTo(e2.getAge());
                    }
                }).forEach(System.out::println);
    }
}
