package com.test;

public class Test2 {
    public static void main(String[] args) {
        int num = check("8617768128989");
        System.out.println(num);
    }

    public static int check(String phone) {
        if (phone == null && phone.trim().equals("")) {
            return -1;
        }

        int num = 0;
        if (phone.length() < 13 && phone.length() != 13) {
            return 1;
        }

        if (!phone.matches("^\\d+$")) {
            return 2;
        }

        if (!phone.substring(0, 2).equals("86")) {
            return 3;
        }

        if (phone.matches("^(86)\\d{11}")) {
            return 0;
        }

        return -1;
    }
}
