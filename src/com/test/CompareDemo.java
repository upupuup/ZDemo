package com.test;

import java.util.Scanner;

public class CompareDemo {
    public static void main(String[] args) {
        // 输入字符串A
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter string");
        String strA = scanner.nextLine();

        // 输入字符串B
        scanner = new Scanner(System.in);
        System.out.println("enter another string");
        String strB = scanner.nextLine();
        int length = compared(strA, strB);

        System.out.println(length);
    }

    public static int compared(String strA, String strB) {
        // 对子串判空
        if (strA != null && strB != null && strA.trim().equals("") && strB.trim().equals("")) {
            return -1;
        }

        String min;
        String max;
        if (strA.length() < strB.length()) {
            min = strA;
            max = strB;
        } else {
            min = strB;
            max = strA;
        }

        for (int i = 0; i < min.length(); i++) {
            for (int beg = 0, end = min.length() - i; end <= min.length(); beg++, end++) {
                //取子串
                String s = min.substring(beg, end);

                //如果大串中含有子串，则返回子串，该子串就是最大的公共子串
                //这里也可以使用java中String类提供的contains()方法，这里选择自己写一个类似的方法
                if (max.contains(s)) {
                    return s.length();
                }
            }
        }
        return -1;
    }
}
