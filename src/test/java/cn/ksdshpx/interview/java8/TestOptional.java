package cn.ksdshpx.interview.java8;

import org.junit.Test;

import java.util.Optional;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/31
 * Time: 9:45
 * Description:Optional容器类
 * Optional的常用方法
 *      Optional.of(T t):创建一个Optional实例
 *      Optional.empty():创建一个空的Optional实例
 *      Optional.ofNullable(T t):若t不为null,创建Optional实例,否则创建空实例
 *      isPresent():判断是否包含值
 *      orElse(T t):如果调用对象包含值,返回该值,否则返回t
 *      orElseGet(Supplier s):如果调用对象包含值,返回该值,否则返回s获取的值
 *      map(Function t):如果有值,对其处理,并返回处理后的Optional,否则返回Optional.empty()
 *      flatMap(Function mapper):与map类似,要求返回值必须是Optional
 */
public class TestOptional {
    @Test
    public void test01() {
        Optional<Employee> op = Optional.of(new Employee());
        Employee emp = op.get();
        System.out.println(emp);
    }

    @Test
    public void test02() {
        Optional<Employee> op = Optional.empty();
        System.out.println(op.get());
    }

    @Test
    public void test03() {
        Optional<Employee> op = Optional.ofNullable(null);
        if (op.isPresent()) {
            System.out.println(op.get());
        }

        /*Employee emp = op.orElse(new Employee("haha", 18, 9000.00));
        System.out.println(emp);*/
        Employee emp = op.orElseGet(Employee::new);
        System.out.println(emp);
    }

    @Test
    public void test04(){
        Optional<Employee> op = Optional.ofNullable(new Employee("liSi", 18, 9090.00));
        /*Optional<String> empName = op.map(Employee::getName);
        System.out.println(empName.get());*/
        Optional<String> empName = op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(empName.get());
    }
}
