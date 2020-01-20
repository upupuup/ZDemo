package com.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: jiangzhihong
 * @CreateDate: 2019/6/26 15:00
 * @Version: 1.0
 * @Description: [java类作用描述]
 */
public class LambdaDemo {
	public static void main(String[] args) {
		listForEach();
		squareOfNumber();
	}

	/**
	 * 遍历list
	 */
	public static void listForEach() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		list.forEach(n -> System.out.println(n));
		System.out.println("------------");
		// System.out::println 等价 n -> System.out.println(n)
		list.forEach(System.out::println);
	}

	/**
	 * 计算一个数的平方
	 */
	public static void squareOfNumber() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		list.stream().map(x -> x * x).forEach(System.out::println);
		Integer sum = list.stream().map(x -> x * x).reduce((x, y) -> x + y).get();
		System.out.println("总数：" + sum);
	}
}
