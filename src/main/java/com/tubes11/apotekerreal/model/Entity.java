package com.tubes11.apotekerreal.model;

public abstract class Entity {
    public String doctorName;
    public String specialization;
    public String doctorScedule;

    public Entity(){
    }

    public Entity(String doctorName, String specialization, String doctorScedule){
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.doctorScedule = doctorScedule;
    }

    public String getDoctorName(){
        return doctorName;
    }

    public String getSpecialization(){
        return specialization;
    }

    public String getDoctorScedule(){
        return doctorScedule;
    }

    public void setDoctorName(String doctorName){
        this.doctorName = doctorName;
    }

    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }

    public void setDoctorScedule(String doctorScedule){
        this.doctorScedule = doctorScedule;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
