package com.example.myunittest;

public class TabungModel {
    private double length;
    private double height;
    public TabungModel() {
    }
    public void save(double length, double height) {
        this.length = length;
        this.height = height;
    }
    double volume() {
        return 3.14 * length * length * height;
    }
    public double luasTabung() {
        double wh = 2 * 3.14 * length * height;
        double lh = 2 * 3.14 * length * length;
        return wh + lh;
    }
    public double luasSelimut() {
        return 2 * 3.14 * length * height;
    }

}
