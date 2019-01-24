package com.singleDemo;

/**
 * 饿汉式加载
 */
public class Single2 {
    // 类加载时就实例化对象
    private static final Single2 single2 =  new Single2();

    public static Single2 getInstance() {
        // 立即返回
        return single2;
    }
}
