package com.kaatyassss.laba4;

import java.util.Objects;

public class AnotherOperation implements Printable {

    private final int id;
    private int time;

    public AnotherOperation(int id, int time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public String getInfo() {
        return "Операция " + id + ": время - " + time + ".";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnotherOperation operation = (AnotherOperation) o;
        return id == operation.id && time == operation.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time);
    }
}
