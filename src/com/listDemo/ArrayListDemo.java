package com.listDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> firstList =  new ArrayList<>();
        System.out.println("list初始化的大小：" + firstList.size() + "===");
        firstList.add("one");
        firstList.add("one");
        firstList.add("two");
        firstList.add(2, "three");

        for (int i = 0; i < firstList.size(); i++) {
            if ("one".equals(firstList.get(i))) {
                firstList.remove(i);
            }
        }

        System.out.println("第一次删除：" + firstList.size());

       if (true) {
           return ;
       }

        Iterator<String> iter = firstList.iterator();
        while (iter.hasNext()) {
            if ("three".equals(iter.next())) {
                iter.remove();
            }
        }

        System.out.println("第二次删除：" + firstList.size());

        List<String> secondtList =  new ArrayList<>();
        secondtList.add("aa");
        secondtList.add("bb");
        secondtList.add("cc");
        for (String item : secondtList) {
            System.out.println(item);
            if (item.equals("aa")) {
                secondtList.remove(item);
                break;
            }
        }
    }
}
