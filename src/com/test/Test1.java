package com.test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        String s = "9-8×2/9-2";
        int result = getMyRet(s);
        System.out.println("最后结果：" + result);
    }

    public static int getMyRet(String s1) {
        int len = s1.length();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < len; i++)
            list.add(s1.charAt(i) + "");

            System.out.println("list--->" + list);

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).equals("×")) {
                    int ji = Integer.parseInt(list.get(j - 1)) * Integer.parseInt(list.get(j + 1));
                    list.add(j - 1, ji + "");// 把ji插入到原来x的前一位，原来的后移。从8开始往后移
                    list.remove(j);// 删除8；remove是删除当前位置后后面的前移；故x到了j这个下标位置。
                    list.remove(j);// 删除x
                    list.remove(j);// 删除9
                    System.out.println("list--x后->" + list);

                    j--;// 相当于这次循环木有跳动下一个下标，因为马上要对ji参与运算，而不是跳过
                } else if (list.get(j).equals("/")) {
                    int shang = Integer.parseInt(list.get(j - 1)) / Integer.parseInt(list.get(j + 1));
                    list.add(j - 1, shang + "");
                    list.remove(j);
                    list.remove(j);
                    list.remove(j);
                    System.out.println("list--/后->" + list);
                    j--;
                }
            }

            for (int k = 0; k < list.size(); k++) {// 这个时候是新的size
                if (list.get(k).equals("+")) {
                    int he = Integer.parseInt(list.get(k - 1)) + Integer.parseInt(list.get(k + 1));
                    list.add(k - 1, he + "");
                    list.remove(k);
                    list.remove(k);
                    list.remove(k);
                    System.out.println("list--+后->" + list);
                    k--;
                }
                if (list.get(k).equals("-")) {
                    int cha = Integer.parseInt(list.get(k - 1))
                            - Integer.parseInt(list.get(k + 1));
                    list.add(k - 1, cha + "");
                    list.remove(k);
                    list.remove(k);
                    list.remove(k);
                    System.out.println("list--  -后->" + list);
                    k--;
                }
            }
            int sum = Integer.parseInt(list.get(0));
            return sum;
    }
}
