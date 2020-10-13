package com.listDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: jiangzhihong
 * @CreateDate: 2020/1/21 13:35
 * @Version: 1.0
 * @Description: [java类作用描述]
 */
public class ModCountList {
	public static void main(String[] args) {
//		List<String> list = new ArrayList<String>();
		final String str;
		str = "11111111";
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object next = iterator.next();
			if (next.equals("c")) {
				list.remove("c");
			} else {
				System.out.println(next);
			}
		}
	}
}
