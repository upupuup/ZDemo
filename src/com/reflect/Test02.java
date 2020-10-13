package com.reflect;

/**
 * 反射
 * @Author:         jiangzhihong
 * @CreateDate:     2020/10/13 12:53
 */
public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> c1 = Class.forName("com.reflect.User");
		Class<?> c2 = Class.forName("com.reflect.User");
		Class<?> c3 = Class.forName("com.reflect.User");
		Class<?> c4 = Class.forName("com.reflect.User");

		User user = new User();
		Class<? extends User> aClass = user.getClass();

		Class c5 = User.class;


		// 一个类在内存中只有一个class对象。一个类被加载之后，类的整个结构都会封装在Class对象中
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		System.out.println(c4.hashCode());

	}
}

class User {
	private String name;
	private int id;
	private int age;
	public User() {}

	public User(String name, int id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", id=" + id +
				", age=" + age +
				'}';
	}

	private void test() {
		System.out.println("test");
	}
}
