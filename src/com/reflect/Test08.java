package com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description: 获取类信息
 * @Author: jiangzhihong
 * @CreateDate: 2020/10/13 20:43
 */
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class<?> c1 = Class.forName("com.reflect.User");

        // 包名+类名
        System.out.println(c1.getName());
        // 获得类名
        System.out.println(c1.getSimpleName());

        // 获取类的属性，没有打印出属性，只能打印public
        Field[] fields = c1.getFields();
        Arrays.stream(fields).forEach(field -> System.out.println(field));

        System.out.println("新的方法");

        // 可以打印所有的属性
        Field[] declaredFields = c1.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> System.out.println(field));

        // 获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        // 获得类的方法
        System.out.println("==========================");

        // 获得本类和父类的所有的public方法
        Method[] methods = c1.getMethods();
        Arrays.stream(methods).forEach(method -> System.out.println("正常的" + method));

        System.out.println("==========================");
        // 获取本类的所有的方法
        Method[] declaredMethods = c1.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(method -> System.out.println("本类的" + method));

        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);

        System.out.println("==========================");
        System.out.println(getName);
        System.out.println(setName);
    }
}
