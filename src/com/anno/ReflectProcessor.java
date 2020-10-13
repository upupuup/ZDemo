package com.anno;

import java.lang.reflect.Method;
/**
 * @Author:         jiangzhihong
 * @CreateDate:     2020/10/13 9:31
 */
public class ReflectProcessor {
	public void parseMethod(final Class<?> clazz) throws Exception {
		final Object obj = clazz.getConstructor(new Class[] {}).newInstance(new Object[] {});
		final Method[] methods = clazz.getDeclaredMethods();
		for (final Method method : methods) {
			final Reflect my = method.getAnnotation(Reflect.class);
			if (null != my) {
				method.invoke(obj, my.name());
			}
		}
	}
}
