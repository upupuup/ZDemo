package com.reflect;

import java.lang.reflect.Field;
import java.util.Arrays;

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

        // 获取类的属性，没有打印
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("新的方法");

        //
        Field[] declaredFields = c1.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> System.out.println(field));
    }
}
