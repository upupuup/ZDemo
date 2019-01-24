package com.synchronizedDemo;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop:" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
