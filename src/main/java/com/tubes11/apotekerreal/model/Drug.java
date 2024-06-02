package com.tubes11.apotekerreal.model;

import java.util.ArrayList;
import java.util.List;

public class Drug {
    private int idDrug;
    private String namaObat;
    private  int jumlahObat;
    private double hargaObat;
    private static List<Drug> drugs;

    public Drug(int idDrug, String namaObat, int jumlahObat, double hargaObat) {
        this.idDrug = idDrug;
        this.namaObat = namaObat;
        this.jumlahObat = jumlahObat;
        this.hargaObat = hargaObat;
    }

    public Drug(){
        drugs = new ArrayList<>();
    }

    public int getIdDrug(){
        return idDrug;
    }

    public String getNamaObat() {
        return namaObat;
    }
    
    public  int getJumlahObat() {
        return jumlahObat;
    }

    public double getHargaObat() {
        return hargaObat;
    }
    
    public void setIdDrug(int idDrug){
        this.idDrug = idDrug;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public void setJumlahObat(int jumlahObat) {
        this.jumlahObat = jumlahObat;
    }

    public void setHargaObat(double hargaObat) {
        this.hargaObat = hargaObat;
    }

    public static void addNewDrug(Drug data){
        drugs.add(data);
    }

    static {
        drugs =  new ArrayList<>();
    }
}
