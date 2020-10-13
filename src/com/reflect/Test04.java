package com.reflect;

import java.lang.annotation.ElementType;

/**
 * 所有类型的class
 * @Author:         jiangzhihong
 * @CreateDate:     2020/10/13 13:43
 */
public class Test04 {
	public static void main(String[] args) {
		// 类
		Class<Object> c1 = Object.class;
		// 接口
		Class<Comparable> c2 = Comparable.class;
		// 数组，一维数组，二维数组
		Class<String[]> c3 = String[].class;
		Class<int[][]> c4 = int[][].class;

		// 注解
		Class<Override> c5 = Override.class;

		// 枚举
		Class<ElementType> c6 = ElementType.class;

		// 基本数据类型
		Class<Integer> c7 = Integer.class;

		Class<Void> c8 = void.class;

		Class<Class> c9 = Class.class;

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(c7);
		System.out.println(c8);
		System.out.println(c9);

	}
}
