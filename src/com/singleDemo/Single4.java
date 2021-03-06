package com.singleDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * 双重检验锁
 */
public class Single4 {
    private static volatile Single4 single4;

    private Single4() {
        System.out.println("hahhahaha");
    }

    // 双重检查获取单例实例
    public static Single4 getInstance() {
        // 多线程直接访问，不做控制，不影响性能
        if (single4 == null) {
            // 此时，如果有多个线程进入，则会进入同步块，其余线程等待
            synchronized(Single4.class) {
                // 此时，第一个进入的线程判断为空，但是第二个进来就不是空了
                if (single4 ==null) {
                    // 第一个线程实例化此对象
                    single4 = new Single4();
                }
            }
        }
        // 如果不为空，不会影响性能，只有第一次才会影响性能
        return single4;
    }

    public static void main(String[] args) throws Exception {
        Single4 instance = Single4.getInstance();
        Class<Single4> single4Class = Single4.class;
        Constructor<Single4> declaredConstructor = single4Class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Single4 single4 = declaredConstructor.newInstance(null);

        int modifiers = single4Class.getModifiers();
        System.out.println(modifiers + "===" + Modifier.toString(modifiers));
        System.out.println(modifiers & 16384);
    }
}
