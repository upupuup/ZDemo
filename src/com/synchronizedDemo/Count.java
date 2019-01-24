package com.synchronizedDemo;

public class Count {

    // 含有同步块的方法
    public void syncMethod() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread() + " syncMethod: " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 非同步方法
//    public void nonSynMethod() {
//        try {
//            for (int i = 0; i < 5; i++) {
//                Thread.sleep(100);
//                System.out.println(Thread.currentThread() + "nonSynMethod: " + i);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    // 此方法与上面注释的方法只是相差一个synchronized(this)
    public void nonSynMethod() {
        try {
            synchronized(this) {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " nonSynMethod: " + i);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
