package com.thread;

/*
 * @Author:         jiangzhihong
 * @CreateDate:     2020/12/29 11:14
 */
public class Cpu {
	public static void main(String[] args) {
		while (true) {
			for(int i = 0; i < 1000000; i++) {
				System.out.println(i);
			}
		}
	}
}
