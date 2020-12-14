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
		userDemo();
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
		queryList.add(new User(1L, 1L, "hhh"));
		queryList.add(new User(1L, 1L, "hohoho"));
		queryList.add(new User(1L, 2L, "hhhh2222"));
		queryList.add(new User(1L, 2L, "hohoh2222"));
		/**
		 * 方法一
		 * 去除有相同用户主键的数据
		 * Collectors.collectingAndThen(W,M) 返回一个收集器
		 * W：要转换的收集器 M：转换函数
		 */
		queryList = queryList.stream().collect(Collectors.collectingAndThen(
					Collectors.toCollection(()->
							new TreeSet<>(Comparator.comparing(obj -> obj.getUserId()))
					), ArrayList::new));

		// 方法二
		Map<Long, User> collect = queryList.stream().collect(Collectors.toMap(
				User::getUserId, user -> user, (k1, k2) -> k1));
		List<User> users = new ArrayList<>(collect.values());

		System.out.println(users.toString());
	}
}
