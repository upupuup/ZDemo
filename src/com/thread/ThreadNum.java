package com.thread;

/*
 * @Author:         jiangzhihong
 * @CreateDate:     2021/1/23 14:23
 */
public class ThreadNum {
	private static final int _1MB = 1024 * 1024;
	public static void main(String[] args) {
		byte[] allo1, allo2, allo3;
		allo1 = new byte[_1MB / 4];
		allo2 = new byte[_1MB * 8];
		allo3 = new byte[_1MB * 4];
		allo3 = null;
		allo3 = new byte[4 * _1MB];
	}
}
