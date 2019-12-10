package cn.ksdshpx.interview.java8;

import org.junit.Test;

import java.util.*;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/10
 * Time: 10:59
 * Description:为什么使用Lambda表达式
 */
public class TestLambda {
    //原来的匿名内部类
    @Test
    public void test01() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

    //使用Lambda表达式
    @Test
    public void test02() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> treeset = new TreeSet<>(comparator);
    }

    //需求:获取当前公司中员工年龄大于35的员工信息
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    public List<Employee> filterEmployees(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }
        return emps;
    }

    @Test
    public void test03() {
        List<Employee> employees = filterEmployees(this.employees);
        System.out.println(employees);
    }

    //需求:获取当前公司员工中工资大于5000的员工信息
    public List<Employee> filterEmployees2(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getSalary() >= 5000) {
                emps.add(emp);
            }
        }
        return emps;
    }

    //优化方式一:策略设计模式
    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> predicate) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (predicate.test(emp)) {
                emps.add(emp);
            }
        }
        return emps;
    }

    @Test
    public void test04() {
        List<Employee> employeesByAge = filterEmployee(employees, new FilterEmployeeByAge());
        System.out.println(employeesByAge);
        System.out.println("----------------");
        List<Employee> employeesBySalary = filterEmployee(employees, new FilterEmployeeBySalary());
        System.out.println(employeesBySalary);
    }

    //优化方式二:匿名内部类
    @Test
    public void test05() {
        List<Employee> employeeByAge = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee e) {
                return e.getSalary() <= 5000;
            }
        });
        System.out.println(employeeByAge);
    }

    //优化方式三:Lambda表达式
    @Test
    public void test06() {
        List<Employee> employeeByAge = filterEmployee(employees, (e) -> e.getSalary() >= 5000);
        employeeByAge.forEach(System.out::println);
    }

    //优化方式四:Stream API
    @Test
    public void test07() {
        employees.stream()
                .filter((e) -> e.getSalary() >= 5000)
                .forEach(System.out::println);
    }
}
