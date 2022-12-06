package com.kaatyassss.laba4;

public class Employee implements Printable {

    private static int n;
    private final int id;
    private String name;

    public Employee(String name) {
        this.id = ++n;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getInfo() {
        return "рабочий № " + id + ", имя рабочего: " + name;
    }
}
