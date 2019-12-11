package cn.ksdshpx.interview.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/11
 * Time: 13:36
 * Description:Lambda表达式的基础语法
 *      Java8中引入了一个新的操作符"->",该操作符称为箭头操作符或Lambda操作符
 *      箭头操作符将Lambda表达式拆分成两部分
 *      左侧：Lambda表达式的参数列表
 *      右侧：Lambda表达式所需执行的功能，即Lambda体
 *
 *      语法格式一：无参数，无返回值
 *                () -> System.out.println("Hello Lambda!");
 *
 *      语法格式二：有一个参数，无返回值
 *                (x) -> System.out.println(x);
 *
 *      语法格式三：若只有一个参数，小括号可以省略不写(不推荐)
 *                 x -> System.out.println(x);
 *
 *      语法格式四：有两个以上的参数，有返回值，并且Lambda体中有多条语句
 *          Comparator<Integer> comparator = (x,y) -> {
 *             System.out.println("函数式接口");
 *             return Integer.compare(x,y);
 *         };
 *
 *      语法格式五：若Lambda体中只有一条语句，那么return和大括号都可以不写（不推荐）
 *                Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);
 *
 *      语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译期可以通过上下文
 *                推断出数据类型，即"类型推断"
 *                (Integer x,Integer y) -> Integer.compare(x,y)
 *
 *      总结：左右遇一括号省，左侧推断类型省
 *
 *           Lambda表达式需要函数式接口的支持
 *           什么是函数式接口？==>若接口中只有一个抽象方法，则称为函数式接口，
 *                             可以使用@FunctionalInterface修饰,可以检查是否是函数式接口
 */
public class TestLambda2 {
    @Test
    public void test01(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Runnable1!");
            }
        };
        new Thread(r).start();
        System.out.println("-------------");
        Runnable r2 = () -> System.out.println("Hello Runnable2!");
        new Thread(r2).start();
        System.out.println("-------------");
        new Thread(()-> System.out.println("Hello Runnable3!")).start();
    }

    @Test
    public void test02(){
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("Hello Consumer!");
    }

    @Test
    public void test03(){
        Comparator<Integer> comparator = (x,y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }

    @Test
    public void test04(){
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);
    }

    //需求：对一个数进行运算
    @Test
    public void test05(){
        Integer result = operation(100, (x) -> x * x);
        System.out.println(result);
        System.out.println("--------------");
        result = operation(200,(y) -> y + 10);
        System.out.println(result);
    }

    public Integer operation(Integer num,MyFun mf){
        return mf.getValue(num);
    }
}
