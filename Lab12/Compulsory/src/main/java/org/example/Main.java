package org.example;

import java.lang.reflect.Method;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Facultate\\Java\\PA2023_A5\\Lab12\\Compulsory\\target\\classes\\org\\example\\TestClass.class";
        Analyzer analyzer = new Analyzer(path);
        String packageName = analyzer.getPackageName();
        String className = analyzer.getClassName();
        Method[] methods = analyzer.getMethods();

        System.out.println("Package: " + packageName);
        System.out.println("Class: " + className);

        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}