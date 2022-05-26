package com.example.myunittest;

public class CuboidModel {
    private double massa;
    private double percepatan;
    private double tinggi;
    private double kecepatan;
    public CuboidModel() {
        }
        public void save(double massa, double percepatan, double tinggi, double kecepatan) {
        this.massa = massa;
        this.percepatan = percepatan;
        this.tinggi = tinggi;
        this.kecepatan = kecepatan;
        }

        double getEP() { //menghitung volume
        return massa * percepatan * tinggi;
        }

        public double getEM() { //menghitung energi mekanik surface area
        double ep = massa * percepatan * tinggi;
        double ek = 0.5 * massa * kecepatan * kecepatan;
        return ep + ek;
        }
        public double getEK() {
        return 0.5 * massa * kecepatan * kecepatan;
        } //energi kinetik circum ference
}
