package com.kaatyassss.laba4;

public class FreeOperation extends Operation {

    private final int id;
    private int time;

    public FreeOperation(int time) {
        this.id = ++n;
        this.time = time;
    }

    @Override
    public String getInfo() {
        return "Операция " + id + ": время - " + time + ", стоимость - бесплатно.";
    } //+

    @Override
    public int getTime() {
        return time;
    }

    @Override
    public void setTime(int time) {
        this.time = time;
    }
}
