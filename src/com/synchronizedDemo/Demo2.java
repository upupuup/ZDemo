package com.synchronizedDemo;

/**
 * 比较Demo2 和 Demo1，我们发现，Demo2中的MyThread类是直接继承于Thread，
 * 而且t1和t2都是MyThread子线程。
 * 幸运的是，在“Demo2的run()方法”也调用了synchronized(this)，
 * 正如“Demo1的run()方法”也调用了synchronized(this)一样！
 * 那么，Demo2的执行流程是不是和Demo1一样呢？
 *
 *
 * 如果这个结果一点也不令你感到惊讶，那么我相信你对synchronized和this的认识已经比较深刻了。
 * 否则的话，请继续阅读这里的分析。
 * synchronized(this)中的this是指“当前的类对象”，即synchronized(this)所在的类对应的当前对象。
 * 它的作用是获取“当前对象的同步锁”。
 * 对于Demo2中，synchronized(this)中的this代表的是MyThread对象，而t1和t2是两个不同的MyThread对象，
 * 因此t1和t2在执行synchronized(this)时，获取的是不同对象的同步锁。对于Demo1对而言，
 * synchronized(this)中的this代表的是MyRunable对象；t1和t2共同一个MyRunable对象，
 * 因此，一个线程获取了对象的同步锁，会造成另外一个线程等待。
 */
public class Demo2 {
    public static void main(String[] args) {
        Thread thread1 = new MyThread("t1");
        Thread thread2 = new MyThread("t2");
        thread1.start();
        thread2.start();
    }
}
