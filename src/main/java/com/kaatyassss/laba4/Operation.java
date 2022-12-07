package com.kaatyassss.laba4;


import java.util.Objects;

public class Operation implements Printable {

    protected static int n;
    private int id;
    private int time;
    private int cost;

    public Operation(int time, int cost) {
        this.id = ++n;
        this.time = time;
        this.cost = cost;
    }

    protected Operation() {
    }

    @Override
    public String getInfo() {
        return "Операция " + id + ": время - " + time + ", стоимость - " + cost + "."; //+
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return time == operation.time && cost == operation.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, cost);
    }
}
