package com.kaatyassss.laba4;

public class AnotherOperation implements Printable {

    private final int id;
    private int time;

    public AnotherOperation(int id, int time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public String getInfo() {
        return "Операция " + (id + 1) + ": время - " + time + ".";
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }
}
