package com.dataDemo;

/**
 *  判断一个数是否是2的乘方
 */
public class IsTwoSquare {
    public static void main(String[] args) {
        int num = 0b1000;
        fun1(num);
        fun2(num);
    }

    /**
     * 方法一,从1开始，一直乘2，然后和num匹配
     * @param num 二进制数
     */
    private static void fun1(int num) {
        int temp = 1;
        while(temp <= num) {
            if (temp == num) {
                System.out.println(num + "是2的乘方");
                return ;
            }
            temp *= 2;
        }
        System.out.println(num + "不是2的乘方");
    }

    /**
     * 方法二，如果一个数n是2的乘方，那么num & (num - 1)的结果是0
     * @param num 二进制数
     */
    private static void fun2(int num) {
        if ((num & (num - 1)) == 0) {
            System.out.println(num + "是2的乘方");
        } else {
            System.out.println(num + "不是2的乘方");
        }
    }
}
