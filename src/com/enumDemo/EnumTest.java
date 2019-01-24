package com.enumDemo;

import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size: (SMALL, NEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase();

        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());

        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job!");
        } else {
            System.out.println("bad!");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word:");
        String str = scanner.next().toUpperCase();
        System.out.println(str + "+" + Size.EXTRA_LARGE);
        if (Size.EXTRA_LARGE.equals(str)) {
            System.out.println("good job");
        } else {
            System.out.println("bad");
        }

        System.out.println(Const.OrderStatusEnum.PAID.getCode() + ":"
                + Const.OrderStatusEnum.PAID.getValue() + ":"
                + Const.OrderStatusEnum.PAID.getDesc());
    }

    enum Size {
        SMALL("S"), MEDIUM("M"), LARGE("LARGE"), EXTRA_LARGE("EXTRA_LARGE");
        private String abbreviation;

        private Size(String abbreviation){
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation() {
            return abbreviation;
        }
    }
}
