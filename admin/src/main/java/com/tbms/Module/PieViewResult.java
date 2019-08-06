package com.tbms.Module;

public class PieViewResult {

    private String name;

    private Double y;

    public PieViewResult(String name, Double y) {
        this.name = name;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", y=" + y +
                '}';
    }
}
