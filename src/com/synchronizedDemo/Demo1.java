package com.synchronizedDemo;

public class Demo1 {
    public static void main(String[] args) {
        // 新建Runnable
        Runnable demo = new MyRunnable();

        Thread t1 = new Thread(demo, "t1");
        Thread t2 = new Thread(demo, "t2");

        t1.start();
        t2.start();


    }
}
