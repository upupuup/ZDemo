package com.reflect;

/**
 * 测试类什么时候初始化
 * @Author:         jiangzhihong
 * @CreateDate:     2020/10/13 17:13
 */
public class Test06 {
	static {
		System.out.println("main类被加载");
	}

	public static void main(String[] args) throws ClassNotFoundException {
		// 主动引用
		// Son son = new Son();

		// 反射也会产生主动引用
		// Class<?> aClass = Class.forName("com.reflect.Son");

		// 不会产生类引用的方法，不会加载字类
//		System.out.println(Son.b);
		
		// 数组也不会初始化
		Son[] sons = new Son[5];
		// 引用常量不会初始化，常量在链接阶段存入常量池中
		System.out.println(Son.M);
	}
}

class Father {
	static int b = 2;
	static {
		System.out.println("父类被加载");
	}
}

class Son extends Father {
	static {
		System.out.println("子类被加载");
		m = 300;
	}

	static int m = 100;
	static final int M = 1;
}
