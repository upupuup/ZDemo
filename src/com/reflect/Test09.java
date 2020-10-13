package com.reflect;

/**
 * @Description: 动态创建对象，通过反射
 * @Author: jiangzhihong
 * @CreateDate: 2020/10/13 21:15
 */
public class Test09 {
    public static void main(String[] args) throws Exception {
        Class<?> c1 = Class.forName("com.reflect.User");

        // 本质是无参构造器
        User user = (User) c1.newInstance();
        System.out.println(user);
    }
}
