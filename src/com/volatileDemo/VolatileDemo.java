package com.volatileDemo;

public class VolatileDemo {
    public volatile static int count = 0;

    public static void main(String[] args) {
        // 开启十个线程
        for (int i = 0; i < 10; i++) {
            new Thread(
                new Runnable() {
                    public void run() {
                      try {
                          Thread.sleep(1);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      // 每个线程让count自增100次
                      for (int i = 0; i < 100; i++) {
                          count++;
                      }
                    }
                }
            ).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count=" + count);
    }
}
