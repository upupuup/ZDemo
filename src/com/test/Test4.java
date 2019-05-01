package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入总人数");
        int totalNum = scanner.nextInt();
        System.out.println("请输入报数的大小");
        int cyclenNum = scanner.nextInt();
        circle(totalNum, cyclenNum);
    }

    public static void circle(int totalNum, int cyclenNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }

        // 从k个数字开始计数
        int k = 0;
        while (start.size() > 0) {
            if (start.size() == 1) {
                System.out.println("最后存活的是" + (start.get(0)));
                return;
            }

            int i = 1;
            k = k + cyclenNum;
            // 第m个人的索引
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println("第" + i + "次淘汰" + start.get(start.size() - 1) + ",k=" + k + ",size=" + start.size());
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println("第" + i + "次淘汰"  + start.get(k)+ ",k=" + k + ",size=" + start.size());
                start.remove(k);
                i++;
            }
        }
    }
}
