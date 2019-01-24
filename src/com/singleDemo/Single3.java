package com.singleDemo;

/**
 * synchronized同步式
 */
public class Single3 {
    private static Single3 single3;

    private Single3() {

    }

    // 同步静态方法，防止并发导致出现两个实例，但还是可以优化
    public synchronized static Single3 getInstance() {
        if (single3 == null) {
            single3 = new Single3();
        }
        return single3;
    }
}
