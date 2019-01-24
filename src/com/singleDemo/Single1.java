package com.singleDemo;

/**
 * 懒汉式单例模式
 */
public class Single1 {
    // 一个静态方法
    private static Single1 single;

    // 私有构造方法
    private Single1() {

    }

    public static Single1 getInstance() {
        // 如果为null，说明没有初始化
        if (single == null) {
            // 初始化实例
            single = new Single1();
        }
        // 返回实例
        return single;
    }
}
