package cn.ksdshpx.interview.concurrency.chapter01;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/15
 * Time: 22:28
 * Description:简单税率策略
 */
public class SimpleTaxCalculateStrategy implements TaxCalculateStrategy {
    private static final Double SALARY_RATE = 0.1;
    private static final Double BONUS_RATE = 0.15;

    @Override
    public Double calculateTax(Double salary, Double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}
