package com.reflect;

import java.lang.reflect.Method;

/**
 * @Description: 性能问题
 * @Author: jiangzhihong
 * @CreateDate: 2020/10/13 22:09
 */
public class Test10 {
    public static void test01() {
        User user = new User();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            user.getName();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("普通方法：" + (endTime - startTime) + "ms");

    }

    public static void test02() throws Exception {
        User user = new User();
        Class<? extends User> c1 = user.getClass();
        Method getName = c1.getMethod("getName", null);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            getName.invoke(user, null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("反射方法：" + (endTime - startTime) + "ms");
    }

    public static void test03() throws Exception {
        User user = new User();
        Class<? extends User> c1 = user.getClass();
        Method getName = c1.getMethod("getName", null);
        // 关闭权限检查，就是可以获取所以普类型的方法
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            getName.invoke(user, null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("关闭权限：" + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) throws Exception {
        test01();
        test02();
        test03();
    }
}
