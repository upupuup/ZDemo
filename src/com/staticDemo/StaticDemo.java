package com.staticDemo;

public class StaticDemo {
    private static String str1 = "staticProperty";
    private String str2 = "property";

    public StaticDemo() {

    }

    public void printFun1() {
        System.out.println(str1);
        System.out.println(str2);
    }

    public static void printFun2() {
        System.out.println(str1);
        // 以下两行报错
//        System.out.println(str2);
//        printFun1();
    }

    static int value = 33;
    String str = "str1";
    public static void main(String[] args) throws Exception{
        new StaticDemo().printValue();
    }

    private void printValue(){
        int value = 3;
        String str = "bb";
        System.out.println(this.value);
        System.out.println(value);
        System.out.println(this.str);
        System.out.println(str);
    }
}
