package cn.ksdshpx.interview.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/12
 * Time: 13:11
 * Description:Lambda表达式的练习
 */
public class TestLambda3 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    /*
        练习一：调用Collections的sort()方法，通过定制排序比较两个Employee(先按
        年龄比，年龄相同按姓名比），使用Lambda作为参数传递
    */
    @Test
    public void test01() {
        Collections.sort(employees, (e1, e2) -> {
            return (e1.getAge() - e2.getAge()) != 0 ? (e1.getAge() - e2.getAge()) : e1.getName().compareTo(e2.getName());
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /*
      练习二：①声明函数式接口，接口中声明抽象方法public String getValue(String str);
             ②声明类TestLambda,类中编写方法使用接口作为参数，将一个字符串转换成大写，并作为方法的返回值
             ③再将字符串的第二个和第四个索引位置进行截取子串
    */
    @Test
    public void test02() {
        String result = strHandler("abcDe", (x) -> x.toUpperCase());
        System.out.println(result);
        result = strHandler(result, (x) -> x.substring(1, 4));
        System.out.println(result);
    }

    //需求:用于处理字符串
    public String strHandler(String str, MyFunction mf) {
        return mf.getValue(str);
    }

    /*
        练习三：①声明一个带两个泛型的函数式接口，泛型类型为<T,R> T为参数 R为返回值
               ②接口中声明对应抽象方法
               ③在TestLambda类中声明方法，使用接口作为参数，计算两个long型参数的和
               ④再计算两个long型参数的乘积
    */

    @Test
    public void test03() {
        op(100L, 200L, (x, y) -> x + y);
        System.out.println("------------");
        op(100L, 200L, (x, y) -> x * y);
    }

    //需求：处理两个Long型的数据
    public void op(Long l1, Long l2, MyFunction2<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }
}
