package com.comTwo;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws Exception {
        SomeClass someClass = new SomeClass();
        Class class1 = someClass.getClass();
        System.out.println(class1.getName());
        System.out.println("");
        System.out.println("Constructors: ");
        Constructor[] constructors = class1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName());
                System.out.println(parameter.getType().getName());

            }
        }
        System.out.println("");
        System.out.println("Methods: ");
        Method[] methods = class1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName());
                System.out.println(parameter.getType().getName());
            }
            System.out.println(Modifier.toString(method.getModifiers()));
            System.out.println(method.getReturnType().getName());
            method.setAccessible(true);
            method.invoke(someClass,"test");
        }
        System.out.println("");
        System.out.println("fields: ");
        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType().getName());
            System.out.println(Modifier.toString(field.getModifiers()));
            field.setAccessible(true);
            System.out.println(field.getInt(someClass));
            field.setInt(someClass, 5);
            System.out.println(field.getInt(someClass));

        }
    }
}

class SomeClass {
    private int i;
    //   String s;

    public SomeClass() {

    }

    public SomeClass(String s) {
        //this.s = s;
    }

    private synchronized String someMethod(String s) {
        System.out.println("this is " + s);
        return s;
    }
}