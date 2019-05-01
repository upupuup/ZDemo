package com.test;

public class Test7 {

    public static void main(String[] args) throws InterruptedException {
        PrintThread printThread = new PrintThread();

        Thread a = new Thread(printThread,"a");
        Thread b = new Thread(printThread, "b");
        Thread c = new Thread(printThread, "c");

        a.start();
        b.start();
        c.start();

    }

}

class PrintThread implements Runnable{
    private int times = 0;

    @Override
    public void run() {
        // 循环30次
        while(times < 30){
            // 使用synchronized锁住对象
            synchronized (this) {

                // 判断是否是线程a，如果是，打印，并唤醒所有线程。不是，进入等待状态。
                if(times % 3 == 0){
                    if("a".equals(Thread.currentThread().getName())){
                        System.out.print("a");
                        times++;

                        // 唤醒所有线程
                        this.notifyAll();
                    } else{
                        try {
                            // 线程等待
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                if(times % 3 == 1){
                    if("b".equals(Thread.currentThread().getName())){
                        System.out.print("b");
                        times++;
                        this.notifyAll();
                    }else{
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                if(times % 3 == 2){
                    if("c".equals(Thread.currentThread().getName())){
                        System.out.print("c");
                        times++;
                        this.notifyAll();
                    }else{
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}