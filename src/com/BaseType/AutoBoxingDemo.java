package com.BaseType;

public class AutoBoxingDemo {
    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * Integer与int类型之间数值的比较
     */
    public static void test1() {
        Integer a = new Integer(3);
        Integer b = new Integer(3);
        Integer c = 3;
        Integer d = 3;
        int e = 3;
        System.out.println("----------test1----------");
        System.out.println(a == b); // false,没有引用同一个对象
        System.out.println(a == c); // false，没有引用同一个对象
        System.out.println(a == e); // true，将Integer类型拆箱成int
        System.out.println(c == d); // true，从常量池中获取值，值的范围是-128~127
        System.out.println(c == e); // true
    }

    public static void test2() {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println("----------test2----------");
        System.out.println(f1 ==  f2); // true,因为常量池里存放的数值范围是-128~127之间，超过这个范围就要new
        System.out.println(f3 == f4); // false
    }
}