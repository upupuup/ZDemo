package com.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Description: 获取反射类型
 * @Author: jiangzhihong
 * @CreateDate: 2020/10/13 22:17
 */
public class Test11 {
    public void test01(Map<String, User> map, List<User> list) {
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws Exception {
        Method method = Test11.class.getMethod("test01", Map.class, List.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();
        Arrays.stream(genericParameterTypes).forEach(type -> System.out.println("参数类型：" + type));
        System.out.println("=====================");
        Arrays.stream(genericParameterTypes).forEach(type -> {
            if (type instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                Arrays.stream(actualTypeArguments).forEach(actualType -> System.out.println("真实的参数类型：" + actualType));
            }
        });
    }
}
