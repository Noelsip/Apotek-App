package com.tubes11.apotekerreal.model;

import java.util.ArrayList;
import java.util.List;

public class Drug {
    private String namaObat;
    private static int jumlahObat;
    private double hargaObat;
    private static List<Drug> drugs;

    public Drug(String namaObat, int jumlahObat, double hargaObat) {
        this.namaObat = namaObat;
        this.jumlahObat = jumlahObat;
        this.hargaObat = hargaObat;
    }

    public Drug(){
        drugs = new ArrayList<>();
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public static int getJumlahObat(String namaObat) {
        return jumlahObat;
    }

    public void setJumlahObat(int jumlahObat) {
        this.jumlahObat = jumlahObat;
    }

    public double getHargaObat() {
        return hargaObat;
    }

    public void setHargaObat(double hargaObat) {
        this.hargaObat = hargaObat;
    }
}
