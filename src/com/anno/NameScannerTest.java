package com.anno;

/**
 * @Author:         jiangzhihong
 * @CreateDate:     2020/10/13 10:49
 */
@NameScanner
public class NameScannerTest {
	@NameScanner
	private String name;

	@NameScanner
	private int age;

	@NameScanner
	public String getName(){
		return this.name;
	}

	@NameScanner
	public void setName(String name){
		this.name = name;
	}

	public static void main(String[] args){
		System.out.println("--finished--");
	}
}
