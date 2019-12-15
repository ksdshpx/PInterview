package cn.ksdshpx.interview.concurrency.chapter01;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/15
 * Time: 22:25
 * Description:税率计算器测试
 */
public class TaxCalculatorMain {
    public static void main(String[] args) {
        /*TaxCalculator taxCalculator = new TaxCalculator(10000d, 2000d) {
            @Override
            protected Double calcTax() {
                return getSalary() * 0.1 + getBonus() * 0.15;
            }
        };
        Double tax = taxCalculator.calcTax();
        System.out.println(tax);*/
        TaxCalculateStrategy strategy = new SimpleTaxCalculateStrategy();
        TaxCalculator taxCalculator = new TaxCalculator(10000d,2000d,strategy);
        Double tax = taxCalculator.calculate();
        System.out.println(tax);
    }
}
