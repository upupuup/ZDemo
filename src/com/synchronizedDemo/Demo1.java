package com.synchronizedDemo;

/**
 * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
 * 其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 * 下面是“synchronized代码块”对应的演示程序。
 *
 *
 * run()方法中存在“synchronized(this)代码块”，而且t1和t2都是基于"demo这个Runnable对象"创建的线程。
 * 这就意味着，我们可以将synchronized(this)中的this看作是“demo这个Runnable对象”；
 * 因此，线程t1和t2共享“demo对象的同步锁”。所以，当一个线程运行的时候，
 * 另外一个线程必须等待“运行线程”释放“demo的同步锁”之后才能运行。
 */
public class Demo1 {
    public static void main(String[] args) {
        // 新建一个Runnable
        Runnable demo = new MyRunnable();

        // 新建线程t1和t2
        Thread t1 = new Thread(demo, "t1");
        Thread t2 = new Thread(demo, "t2");

        // 启动线程t1和t2
        t1.start();
        t2.start();
    }
}
