package com.reflect;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @Description: 反射操作注解
 * @Author: jiangzhihong
 * @CreateDate: 2020/10/13 22:28
 */
public class Teat12 {
    public static void main(String[] args) throws Exception {
        Class<?> c1 = Class.forName("com.reflect.Student2");
        Annotation[] annotations = c1.getAnnotations();
        // 获取注解属性
        Arrays.stream(annotations).forEach(annotation -> {
            System.out.println(annotation);
        });

        // 获取注解属性
        Tablekuang tablekuang = c1.getAnnotation(Tablekuang.class);
        System.out.println(tablekuang.value());

        // 获取注解
        Field name = c1.getDeclaredField("name");
        Fieldkuang fieldkuang = name.getAnnotation(Fieldkuang.class);
        System.out.println(fieldkuang.columnName());
        System.out.println(fieldkuang.type());
        System.out.println(fieldkuang.length());

    }

}

@Tablekuang("db_student")
class Student2 {
    @Fieldkuang(columnName = "id", type = "int", length = 10)
    private int id;
    @Fieldkuang(columnName = "age", type = "int", length = 10)
    private int age;
    @Fieldkuang(columnName = "name", type = "varchar", length = 3)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student2(){}

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


}

/**
 * 类名的注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tablekuang {
    String value();
}

/**
 * 属性的注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldkuang {
    String columnName();
    String type();
    int length();
}