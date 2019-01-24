package com.staticDemo;

public class Test extends Base {
    static {
        System.out.println("test static");
    }

    public Test() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new Test();
    }
}
