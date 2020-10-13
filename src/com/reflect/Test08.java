package com.reflect;

/**
 * @Description: 获取类信息
 * @Author: jiangzhihong
 * @CreateDate: 2020/10/13 20:43
 */
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = Class.forName("com.reflect.User");

        // 包名+类名
        System.out.println(c1.getName());
        // 获得类名
        System.out.println(c1.getSimpleName());
    }
}
