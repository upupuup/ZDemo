package com.set;

import java.util.*;

/**
 * @Author: jiangzhihong
 * @CreateDate: 2019/6/26 13:42
 * @Version: 1.0
 * @Description: [java类作用描述]
 */
public class SetDemo {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		boolean a = set.add("a");
		System.out.println("第一次" + a);
		a = set.add("a");
		System.out.println("第二次" + a);

		HashMap<Integer, String> map = new HashMap<>(16);
		String put = map.put(1, "1111111");
		System.out.println(put);
		put = map.put(1, "122");
		System.out.println(put);
		put = map.put(1, "23");
		System.out.println(put);
		put = map.put(17, "203");
		System.out.println(put);

		ArrayList<String> list = new ArrayList<>();
		boolean add = list.add("1");
		System.out.println(add);
		add = list.add("1");
		System.out.println(add);
		add = list.add("1");
		System.out.println(add);

		TreeMap<Person, String> pdata = new TreeMap<Person, String>();
		pdata.put(new Person("张三", 30), "zhangsan");
		pdata.put(new Person("李四", 20), "lisi");
		pdata.put(new Person("王五", 10), "wangwu");
		pdata.put(new Person("小红", 5), "xiaohong");
		// 得到key的值的同时得到key所对应的值
		Set<Person> keys = pdata.keySet();
		for (Person key : keys) {
			System.out.println(key.getAge() + "-" + key.getName());
		}

		new Thread(
			() -> {
				System.out.print("hello");
				System.out.println("hello");
				System.out.println("hello");
				System.out.println("hello");
			}
		).start();
	}
}

class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * TODO重写compareTo方法实现按年龄来排序
	 */
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		if (this.age > o.getAge()) {
			return 1;
		} else if (this.age < o.getAge()) {
			return -1;
		}
		return age;
	}
}
