package cn.ksdshpx.interview.java8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2019/12/30
 * Time: 13:58
 * Description:测试ForkJoin框架
 */
public class TestForkJoinPool {
    @Test
    public void test01() {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 1000000000L);
        long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗时:" + Duration.between(start, end).toMillis());
    }

    @Test
    public void test02() {
        Instant start = Instant.now();
        long sum = 0L;
        for (long i = 0; i <= 1000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗时:" + Duration.between(start, end).toMillis());
    }

    @Test
    public void test03(){
        Instant start = Instant.now();
        Long sum = LongStream.rangeClosed(0L,1000000000L)
                    .parallel()
                    .reduce(0L,Long::sum);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗时:" + Duration.between(start, end).toMillis());
    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long> {
    private long start;
    private long end;
    private static final long THRESHOLD = 10000L;//临界值

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, middle);
            left.fork();//进行拆分，同时压入线程队列
            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle + 1, end);
            right.fork();//进行拆分，同时压入线程队列
            return left.join() + right.join();
        }
    }
}
