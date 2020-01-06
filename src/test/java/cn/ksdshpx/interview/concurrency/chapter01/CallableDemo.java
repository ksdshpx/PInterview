package cn.ksdshpx.interview.concurrency.chapter01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2020/1/6
 * Time: 14:37
 * Description:创建线程的第三种方式:实现Callable接口
 */
/*class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 1024;
    }
}*/

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1024;
            }
        });*/
        FutureTask<Integer> task = new FutureTask<Integer>(() -> {
            return 1024;
        });
        new Thread(task, "A").start();
        System.out.println(task.get());
    }
}
