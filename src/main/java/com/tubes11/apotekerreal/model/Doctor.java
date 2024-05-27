package com.tubes11.apotekerreal.model;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private int idDoctor;
    private String name;
    private String specialization;
    private ArrayList<String> jadwal;
    private static List<Doctor> doctors;

    public Doctor(int idDoctor, String name, String specialization, ArrayList<String> jadwal) {
        this.idDoctor = idDoctor;
        this.name = name;
        this.specialization = specialization;
        this.jadwal = jadwal;
    }

    public Doctor(){
        doctors = new ArrayList<>();
    }
    public int getIdDoctor(){
        return idDoctor;
    }
    public void setIdDoctor(int idDoctor){
        this.idDoctor = idDoctor;
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

    public static void addNewDoctor(Doctor data){
        doctors.add(data);
    }

    static {
        doctors = new ArrayList<>();
    }
}
