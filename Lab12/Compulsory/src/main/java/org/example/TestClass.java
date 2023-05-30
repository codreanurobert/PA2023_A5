package org.example;

public class TestClass {
    private String name;
    private int id;
    private double value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", value=" + value +
                '}';
    }
}
