package com.BaseType;

public class BaseTypeDemo {
    public static void main(String[] args) {
        short s1 = 1;
        // 错误的方式，因为1是int，s1 + 1需要向下转型，否则会报错
        // s1 = s1 + 1;
        s1 = (short) (s1 + 1);
        System.out.println(s1);
        s1 += 1;
        System.out.println(s1);

        // 错误的方式，因为3.4是双精度，赋值给float需要向下转型
        // float f1 = 3.4;
        float f1 = 3.4f;
    }
}
