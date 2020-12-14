package com.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

	private boolean isPrime(int num) {
		int num2 = (int) Math.sqrt((double) num);
		return IntStream.rangeClosed(2, num2).noneMatch(t -> num % t == 0);
	}

	private Map<Boolean, List<Integer>> getNum(int n) {
		return IntStream.rangeClosed(2, n).boxed().collect(Collectors.partitioningBy(t -> isPrime(t)));
	}

	/**
	 * 去除有相同用户主键的数据
	 */
	public static void userDemo() {
		List<User> queryList = new ArrayList<>();
		// 记得塞数据
		// 去除有相同用户主键的数据
		queryList = queryList.stream().collect(Collectors.collectingAndThen(
				Collectors.toCollection(()->
						new TreeSet<>(Comparator.comparing(obj -> obj.getUserId()))
				), ArrayList::new));
		System.out.println(queryList.toString());
	}
}
