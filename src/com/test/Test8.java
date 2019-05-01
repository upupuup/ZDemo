package com.test;

public class Test8 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = a.length;
        int value = 0;
        int index = search(a, n, value);
        System.out.println(index);
    }

    /**
     * 二分查询
     * @param a 数组
     * @param n 等于目标值的下标
     * @param value 目标值
     * @return
     */
    public static int search(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        // 一定要<=而不能<。因为数组的长度为1的时候并且该值恰好等于目标值时，用<就返回-1。
        while(low <= high) {
            // 计算数组最中间的那个数对应的下标，与mid = (low + high) / 2等价。
            // 以下写法的好处是，low + high的值有可能超出int的范围。>> 1 处理的效率比 / 2效率高。
            int mid = low + ((high - low) >> 1);

            if (value == a[mid]) {
                // 当中间值和目标值相等的话，返回中间值的下标
                return mid;
            } else if (value < a[mid]) {
                // 当中间值大于目标值，将high设置成high = mid - 1，不能是high = mid，
                // 这样有可能出现死循环。例如low和high都是3的时候。
                high = mid - 1;
            } else {
                low = mid - 1;
            }
        }
        return -1;
    }
}
