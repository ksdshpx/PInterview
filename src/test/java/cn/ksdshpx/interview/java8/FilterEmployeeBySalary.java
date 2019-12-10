package cn.ksdshpx.interview.java8;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/10
 * Time: 16:02
 * Description:根据工资过滤雇员
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
