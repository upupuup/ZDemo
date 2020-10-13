package com.annotest;

import java.lang.annotation.*;

/**
 * @Author:         jiangzhihong
 * @CreateDate:     2020/10/13 11:08
 */
public class Test02 {
	@MyAnnotation
	public void test() {

	}
}

/**
 * @Target 注解可以用在哪些地方
 * @Retention 表示需要在什么级别保存改注释信息，用于描述注解的声明周期 runtime>class>source
 * @Documented 表示是否将我们的注解生成在JAVA DOC中
 * @Inherited 字类可以继承父类的注解
 */
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation {

}
