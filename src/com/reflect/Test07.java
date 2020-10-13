package com.reflect;

/**
 * @Description: [java类作用描述]
 * @Author: jiangzhihong
 * @CreateDate: 2020/10/13 20:29
 */
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类加载器的父类加载器-->扩展加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 获取扩展类加载器的父类加载器-->根加载器（c/c++）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        Class<?> c1 = Class.forName("com.reflect.Test07");
        ClassLoader classLoader = c1.getClassLoader();
        System.out.println(classLoader);

    }
}
