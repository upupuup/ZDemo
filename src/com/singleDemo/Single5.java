package com.singleDemo;

/**
 * 既要懒汉式，又要线程安全：静态内部类
 */
public class Single5 {
    private static Single5 single5;

    private Single5() {

    }

    public static Single5 getInstance() {
        return InnerClass.single5;
    }

    // 使用内部静态类，既可以保证懒汉加载，又可以保证线程安全
    private static class InnerClass {
        private static final Single5 single5 = new Single5();
    }

}
