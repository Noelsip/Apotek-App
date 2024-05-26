package com.tubes11.apotekerreal.model;

public class Drug {
    private String namaObat;
    private int jumlahObat;
    private double hargaObat;

    public Drug(String namaObat, int jumlahObat, double hargaObat) {
        this.namaObat = namaObat;
        this.jumlahObat = jumlahObat;
        this.hargaObat = hargaObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public int getJumlahObat() {
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
