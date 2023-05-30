package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Analyzer {
    private String path;
    private Class openedClass;

    public Analyzer(String path) {
        this.path = path;
        openFile(path);
    }
    public void openFile(String path) {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            byte[] classBytes = new byte[fileInputStream.available()];
            try {
                fileInputStream.read(classBytes);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            this.openedClass=new NewClassLoader().defineClass(classBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getPackageName() {
        return openedClass.getPackageName();
    }
    public String getClassName() {
        return openedClass.getName();
    }
    Method[] getMethods() {
        Method[] methods = openedClass.getDeclaredMethods();
        List<Method> methodList = new ArrayList<>();
        for(Method method:methods)
            methodList.add(method);
        return methods;
    }


}
