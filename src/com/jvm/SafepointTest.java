package com.jvm;

/**
 * @Author:         jiangzhihong
 * @CreateDate:     2020/12/28 16:14
 */


// time java SafepointTestp
// 你还可以使用如下几个选项
// -XX:+PrintGC
// -XX:+PrintGCApplicationStoppedTime
// -XX:+PrintSafepointStatistics
// -XX:+UseCountedLoopSafepoints
public class SafepointTest {
	static double sum = 0;

	public static void foo() {
		long startTime = System.currentTimeMillis();
		System.out.println("foo start:" + startTime);
		for (int i = 0; i < 0x77777777; i++) {
			sum += Math.sqrt(i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("foo end:" + endTime);
		System.out.println("foo run time:"  + (endTime - startTime));
	}

	public static void bar() {
		long startTime = System.currentTimeMillis();
		System.out.println("bar start:" + startTime);
		for (int i = 0; i < 50_000_000; i++) {
			new Object().hashCode();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("bar end:" + endTime);
		System.out.println("bar run time:" + (endTime - startTime));
	}

	public static void main(String[] args) {
		new Thread(SafepointTest::foo).start();
		new Thread(SafepointTest::bar).start();
	}
}