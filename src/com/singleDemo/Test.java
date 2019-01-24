package com.singleDemo;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        // 使用set去重
        HashSet<Single1> set = new HashSet<>();

        // window每个进城最多1000个进程
        for (int i = 0; i < 1000; i++) {
            // 并发获取我们的实例
            new Thread(() -> {
                // 向set添加 Project Structure实例
                set.add(Single1.getInstance());
            }).start();
        }

        // 等待10秒
        Thread.sleep(10000);
        System.out.println("我们的single单例模式测试");

        // 循环打印实例，小几率会出现2个或者多个实例
        for (Single1 single : set) {
            System.out.println(single);
        }
    }
}
