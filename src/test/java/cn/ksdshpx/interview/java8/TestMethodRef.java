package cn.ksdshpx.interview.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/13
 * Time: 15:49
 * Description:方法引用、构造器引用以及数组引用
 *      若Lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
 *      (可以理解为方法引用是Lambda表达式的另外一种表现形式)
 *
 *      主要有三种语法格式：
 *          ①对象::实例方法名
 *          ②类::静态方法名
 *          ③类::实例方法名
 *
 *      注意：1.Lambda体中调用方法的参数列表与返回值类型，
 *            要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 *           2.若Lambda参数列表的第一个参数是实例方法的调用者，而第二个
 *            参数是实例方法的参数时，可以使用类名::实例方法名
 *
 *      构造器引用：
 *          语法格式：
 *              类名::new
 *
 *          注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
 *
 *      数组引用：
 *          语法格式：
 *              类型[]::new
 */
public class TestMethodRef {
    //对象::实例方法名
    @Test
    public void test01(){
        Consumer<String> con = (x) -> System.out.println(x);
        System.out.println("==================");
        Consumer<String> con2 = System.out::println;
        con2.accept("abcdef");
    }

    @Test
    public void test02(){
        Employee emp = new Employee("zhangSan",11,8000.0);
        Supplier<String> supplier = () -> emp.getName();
        String name = supplier.get();
        System.out.println(name);
        System.out.println("===================");
        Supplier<Integer> supplier2 = emp::getAge;
        Integer age = supplier2.get();
        System.out.println(age);
    }

    //类::静态方法名
    @Test
    public void test03(){
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);
        System.out.println("=============");
        Comparator<Integer> comparator2 = Integer::compare;
    }

    //类::实例方法名
    @Test
    public void test04(){
        BiPredicate<String,String> biPredicate = (x,y) -> x.equals(y);
        System.out.println("============");
        BiPredicate<String,String> biPredicate2 = String::equals;
    }

    //构造器引用
    @Test
    public void test05(){
        Supplier<Employee> supplier = () -> new Employee();
        Employee employee = supplier.get();
        System.out.println(employee);
        System.out.println("========");
        Supplier<Employee> supplier2 = Employee::new;
        Employee employee2 = supplier2.get();
        System.out.println(employee2);
    }

    //数组引用
    @Test
    public void test06(){
        Function<Integer,String[]> function = (x) -> new String[x];
        String[] str = function.apply(3);
        System.out.println(str.length);
        System.out.println("========");
        Function<Integer,String[]> function2 = String[]::new;
        String[] str2 = function2.apply(20);
        System.out.println(str2.length);
    }
}
