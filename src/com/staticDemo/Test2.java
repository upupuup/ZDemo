package com.staticDemo;

public class Test2 {
    Person person = new Person("Test");
    static{
        System.out.println("test static");
    }

    public Test2() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}
