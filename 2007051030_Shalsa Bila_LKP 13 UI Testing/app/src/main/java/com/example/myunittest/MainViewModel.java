package com.example.myunittest;

public class MainViewModel {
    private final TabungModel tabungModel;
    MainViewModel(TabungModel tabungModel) {
        this.tabungModel = tabungModel;
    }
    void hitung(double l, double h) {
        tabungModel.save(l, h);
    }
    double luasSelimut() {
        return tabungModel.luasSelimut();
    }
    double luasTabung() {
        return tabungModel.luasTabung();
    }
    double volume() {
        return tabungModel.volume();
    }

}
