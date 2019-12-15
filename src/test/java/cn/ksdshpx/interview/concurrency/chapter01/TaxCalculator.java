package cn.ksdshpx.interview.concurrency.chapter01;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/15
 * Time: 22:17
 * Description:税务计算器
 */
public class TaxCalculator {
    private final Double salary;

    private final Double bonus;

    private final TaxCalculateStrategy strategy;

    public TaxCalculator(Double salary, Double bonus, TaxCalculateStrategy strategy) {
        this.salary = salary;
        this.bonus = bonus;
        this.strategy = strategy;
    }

    public Double getSalary() {
        return salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public Double calculate() {
        return strategy.calculateTax(salary,bonus);
    }
}
