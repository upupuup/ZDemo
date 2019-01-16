package com.com.staticDemo;

public class Test1 {
    static {
        System.out.println("test static 1");
    }

    public static void main(String[] args) {

    }

    static {
        System.out.println("test static 2");
    }
}
