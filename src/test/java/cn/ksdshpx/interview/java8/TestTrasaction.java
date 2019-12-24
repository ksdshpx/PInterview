package cn.ksdshpx.interview.java8;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/24
 * Time: 14:33
 * Description:StreamAPI练习
 */
public class TestTrasaction {
    List<Transaction> transactions = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brain = new Trader("Brain", "Cambridge");
        transactions = Arrays.asList(
                new Transaction(brain, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    /**
     * 1.找出2011年发生的所有交易，并按交易额排序（从低到高）
     */
    @Test
    public void test01() {
        transactions.stream()
                .filter((t) -> t.getYear() == 2011)
                .sorted((x, y) -> x.getValue() - y.getValue())
                .forEach(System.out::println);
    }

    /**
     * 2.交易员都在哪些不同的城市工作过
     */
    @Test
    public void test02() {
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 3.查找所有来自剑桥的交易员，并按姓名排序
     */
    @Test
    public void test03() {
        transactions.stream()
                .map(Transaction::getTrader)
                .filter((t) -> "Cambridge".equals(t.getCity()))
                .distinct()
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .forEach(System.out::println);
    }

    /**
     * 4.返回所有交易员的姓名字符串，并按字母顺序排序
     */
    @Test
    public void test04() {
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * 5.有没有交易员在米兰工作的
     */
    @Test
    public void test05() {
        boolean b = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch((t) -> "Milan".equals(t.getCity()));
        System.out.println(b);
    }

    /**
     * 6.打印生活在剑桥的交易员的所有交易额
     */
    @Test
    public void test06() {
        Integer sum = transactions.stream()
                .filter((t) -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    /**
     * 7.所有交易中，最高的交易额是多少
     */
    @Test
    public void test07() {
        Optional<Integer> max = transactions.stream()
                .max((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                .map(Transaction::getValue);
        System.out.println(max.get());
    }

    /**
     * 8.找到交易额最小的交易
     */
    @Test
    public void test08() {
        Optional<Transaction> min = transactions.stream()
                .min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
        System.out.println(min.get());
    }
}
