package com.reflectiveDemo;

import java.util.Date;

public class reflectDemo {
    public static void main(String[] args) {
        // 方法一
        Date d = new Date();
        Class c1 =d.getClass();
        String name = c1.getName();
        System.out.println(name);

        // 方法二
        String className = "java.util.Date";
        Class c2 = null;
        try {
            c2 = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("静态方法获取className：" + c2);
    }
}
