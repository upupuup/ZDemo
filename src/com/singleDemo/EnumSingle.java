package com.singleDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * @Author:         jiangzhihong
 * @CreateDate:     2021/1/23 12:20
 */
public enum EnumSingle {
	INSTANCE;

	public EnumSingle getInstance() {
		return INSTANCE;
	}
}

class EnumTest {
	public static void main(String[] args) throws Exception {
		EnumSingle instance1 = EnumSingle.INSTANCE;
		EnumSingle instance2 = EnumSingle.INSTANCE;
		System.out.println(instance1);
		System.out.println(instance2);

		Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
		declaredConstructor.setAccessible(true);
		int modifiers = declaredConstructor.getModifiers();
		System.out.println(modifiers + "=" + Modifier.toString(modifiers));
		System.out.println(0x00004000);
		System.out.println(2 & 0x00004000);

		EnumSingle instance3 = declaredConstructor.newInstance();
		System.out.println(instance3);
	}
}
