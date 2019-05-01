package com.test;

import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入开始高度");
        int high = scanner.nextInt();

        scanner = new Scanner(System.in);
        System.out.println("请输入第几次");
        int num = scanner.nextInt();
        test(high,num);
    }

    public static void test(double high, double num) {
        double totalHigh = high;
        double onceHigh = high / 2;

        for (int i = 2; i <= num; i++) {
            totalHigh += onceHigh * 2;
            onceHigh /= 2;
        }
        System.out.println(":总路程:" + totalHigh);
        System.out.println(":这一次反弹高度:" + onceHigh);
    }
}
