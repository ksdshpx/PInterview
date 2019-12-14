package cn.ksdshpx.interview.concurrency.chapter01;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/12/14
 * Time: 10:55
 * Description:尝试多线程
 */
public class TryConcurrency {
    public static void main(String[] args) {
        new Thread("ReadFromDB"){
            @Override
            public void run() {
                readDataFromDB();
            }
        }.start();

        new Thread(() -> writeDataToFile(),"WriteToFile").start();
    }

    private static void readDataFromDB() {
        try {
            print(Thread.currentThread().getName() + "==>Begin Read Data From DB");
            Thread.sleep(1000*5L);
            print(Thread.currentThread().getName() + "==>Finish Read Data and Begin Handle it");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print(Thread.currentThread().getName() + "==>Finish Read Data From DB");
    }

    private static void writeDataToFile() {
        try {
            print(Thread.currentThread().getName() + "==>Begin Write Data To File");
            Thread.sleep(1000*5L);
            print(Thread.currentThread().getName() + "==>Finish Write Data and Begin Handle it");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print(Thread.currentThread().getName() + "==>Finish Write Data To File");
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
