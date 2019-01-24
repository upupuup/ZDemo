package com.synchronizedDemo;

/**
 * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
 * 其他线程仍然可以访问“该对象”的非同步代码块。
 * 下面是“synchronized代码块”对应的演示程序。
 *
 *
 * 主线程中新建了两个子线程t1和t2。t1会调用count对象的synMethod()方法，该方法内含有同步块；
 * 而t2则会调用count对象的nonSynMethod()方法，该方法不是同步方法。
 * t1运行时，虽然调用synchronized(this)获取“count的同步锁”；
 * 但是并没有造成t2的阻塞，因为t2没有用到“count”同步锁。
 */
public class Demo3 {
    public static void main(String[] args) {
        final Count count = new Count();

        // 新建t1，t1会调用"count"对象的synMethod方法
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count.syncMethod();
                    }
                }
                , "t1");

        // 新建t2，t2会调用"count"对象的nonSynMethod
        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count.nonSynMethod();
                    }
                }
                , "t2");

        t1.start();
        t2.start();

    }
}
