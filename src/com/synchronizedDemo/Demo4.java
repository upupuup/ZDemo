package com.synchronizedDemo;

/**
 * synchronized代码块可以更精确的控制冲突限制访问区域，有时候表现更高效率。
 */
public class Demo4 {
    // synchronized方法
    public synchronized void synMethod() {
        for (int i = 0; i < 1000000; i++) {
            ;
        }
    }

    //  代码块
    public void synBlock() {
        synchronized (this) {
            for (int i = 0; i < 1000000; i++) {
                ;
            }
        }
    }

    public static void main(String[] args) {
        Demo4 demo = new Demo4();

        long start, diff;
        start = System.currentTimeMillis();
        demo.synMethod();
        diff = System.currentTimeMillis() - start;
        System.out.println("synMethod():" + diff);

        start = System.currentTimeMillis();
        demo.synBlock();
        diff = System.currentTimeMillis() - start;

        System.out.println("sysBlock() :" + diff);


    }


}
