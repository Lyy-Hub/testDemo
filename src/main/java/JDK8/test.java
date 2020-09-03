package JDK8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liYueYang on 2020/3/19.
 */
public class test {

    public static void main(String[] args) {
//        Thread thread1 = new MyThread();
//        thread1.setName("线程1名");
//        thread1.start();
//        Thread thread2 = new MyThread();
//        thread2.setName("线程2名");
//        thread2.start();
//        Thread thread3 = new MyThread();
//        thread3.setName("线程3名");
//        thread3.start();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //模拟耗时操作之后初始化变量 num
                    Thread.sleep(1000);
                    System.out.println("1111");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //模拟耗时操作之后初始化变量 num
                    Thread.sleep(1000);
                    System.out.println("2222");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //模拟耗时操作之后初始化变量 num
                    Thread.sleep(1000);
                    System.out.println("3333");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ",running ....");
        }
    }


}
