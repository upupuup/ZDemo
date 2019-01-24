package com.dataDemo;

/**
 *  判断一个二进制数有几个1
 */
public class NumHasManyOne {

    public static void main(String[] args) {
        int num = 0b1001;
        fun1(num);
        fun2(num);
    }

    /**
     * 方法一：与1相与，然后向右移动一位
     */
    private static void fun1(int num) {
        System.out.print("方法一---计算出二进制数"+ Integer.toBinaryString(num) + "有");
        int count = 0;
        for (int i = 0; num > 0; i++) {
            // 与1相与，判断值是否是1，不是说明这一位是0
            count += num & 1;
            num >>= 1;
        }
        System.out.println(count + "个1");
    }

    /**
     *  方法二，就是与(num - 1)相与，当num为0 的时候，循环结束
     */
    private static void fun2(int num) {
        System.out.print("方法二---计算出二进制数"+ Integer.toBinaryString(num) + "有");
        int count = 0;
        for (int i = 0; num > 0; ++i) {
            num &= (num - 1);
            count++;
        }
        System.out.println(count + "个1");
    }
}
