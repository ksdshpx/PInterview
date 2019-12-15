package cn.ksdshpx.interview.concurrency.chapter01;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/15
 * Time: 22:26
 * Description:税率计算策略
 */
@FunctionalInterface
public interface TaxCalculateStrategy {
    Double calculateTax(Double salary,Double bonus);
}
