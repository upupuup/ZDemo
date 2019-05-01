package com.test;

public class Test3 {
    public static void main(String[] args) {
        int[] a = {0, 30, 155, 1, 80, 30, 170, 40, 99};
        int length = a.length;
        int[] task = new int[length];
        for (int i = 0; i < length; i++) {
            task[i] = i;
        }

        testSort(a, length, task);

        int[] low50 = new int[length];
        int[] to250 = new int[length];

        for (int i = 0; i < task.length; i++) {
            if (task[i] < 50) {

            } else if (task[i] < 250) {

            }
        }
    }

    public static void testSort(int[] a, int n, int[] task) {
        if (n > 1) {
            for (int i = 0; i < n; i++) {
                boolean flag = false;

                for (int j = 0; j < n - i - 1; j++) {
                    if (a[j] > a[j + 1]) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;

                        temp = task[j];
                        task[j] = task[j + 1];
                        task[j + 1] = temp;
                        flag = true;
                    }
                }
                if (!flag) {
                    break;
                }
            }
        }
    }
}
