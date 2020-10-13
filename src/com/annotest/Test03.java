package com.annotest;

import com.sun.istack.internal.Interned;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:         jiangzhihong
 * @CreateDate:     2020/10/13 12:33
 */
public class Test03 {
	@MyAnnotation2(age = 18, name = "xiaojiang")
	public void test() {

	}

	@MyAnnotation3("xiao")
	public void test2() {

	}
}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
	// 注解的参数：参数类型 + 参数名() 如果没有默认值一定要赋值
	String name() default "";
	int age() default 0;
	int id() default -1;
	String[] schools() default {"清华大学", "北京大学"};
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {
	String value();
}
