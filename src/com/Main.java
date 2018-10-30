package com;

import sun.security.krb5.SCDynamicStoreConfig;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) throws Exception {
        SomeClass someClass = new SomeClass();
        Class class1 = someClass.getClass();
        Class class2 = SomeClass.class;
        Class class3 = Class.forName("com.SomeClass");
        SomeClass  someClass1=(SomeClass) class1.newInstance();

        Constructor[] constructors=class1.getDeclaredConstructors();
        for (Constructor constructor:constructors) {
            System.out.println(constructor.getName());
            Parameter[]parameters=constructor.getParameters();
            for (Parameter parameter:parameters) {
                System.out.println(parameter.getName());
                System.out.println(parameter.getType().getName());

            }
        }

    }
}

class SomeClass {
    private static transient int i;
    String s;

    public SomeClass() {

    }

    public SomeClass(String s) {
        this.s = s;
    }

    public String someMethod(String s) {
        System.out.println("this is " + s);
        return s;
    }
}