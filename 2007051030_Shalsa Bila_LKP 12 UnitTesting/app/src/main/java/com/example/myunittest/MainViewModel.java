package com.example.myunittest;

public class MainViewModel {
    private final CuboidModel cuboidModel;
    MainViewModel(CuboidModel cuboidModel) {
        this.cuboidModel = cuboidModel;
        }
    void save(double m, double g, double h, double v) {
        cuboidModel.save(m, g, h, v);
        }
    double getEK() {
        return cuboidModel.getEK();
        }
    double getEM() {
        return cuboidModel.getEM();
        }
    double getEP() {
        return cuboidModel.getEP();
        }
}
