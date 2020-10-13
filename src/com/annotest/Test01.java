package com.annotest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:         jiangzhihong
 * @CreateDate:     2020/10/13 10:58
 */
public class Test01 extends Object {
	@Override
	public String toString() {
		return super.toString();
	}

	@SuppressWarnings("all")
	public void test02() {
		List list = new ArrayList();
	}

	@Deprecated
	public static void test() {
		System.out.println("Deprecated");
	}

	public static void main(String[] args) {
		test();
	}
}
