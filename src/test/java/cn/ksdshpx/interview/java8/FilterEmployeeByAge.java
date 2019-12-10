package cn.ksdshpx.interview.java8;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/10
 * Time: 15:56
 * Description:通过年龄过滤雇员
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
