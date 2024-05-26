package com.tubes11.apotekerreal.model;

import java.util.ArrayList;

public class Doctor {
    private String name;
    private String specialization;
    private ArrayList<String> jadwal;

    public Doctor(String name, String specialization, ArrayList<String> jadwal) {
        this.name = name;
        this.specialization = specialization;
        this.jadwal = jadwal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public ArrayList<String> getJadwal() {
        return jadwal;
    }

    public void setJadwal(ArrayList<String> jadwal) {
        this.jadwal = jadwal;
    }
}
