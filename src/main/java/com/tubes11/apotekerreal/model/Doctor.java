package com.tubes11.apotekerreal.model;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Entity {
    private int idDoctor;
    private int idScedule;
    private boolean selected;
    private ArrayList<String> selectedDays;
    private static List<Doctor> doctors;

    public Doctor(int idDoctor,int idScedule, String doctorName, String specialization, String doctorScedule,Boolean selected, ArrayList<String> selectedDays) {
        super(doctorName, specialization, doctorScedule);
        this.selected = false;
        this.idDoctor = idDoctor;
        this.idScedule = idScedule;
        this.selectedDays = selectedDays;
    }

    public Doctor(){
        super("","","");
        this.idDoctor = 0;
        doctors = new ArrayList<>();
    }
    public int getIdDoctor(){
        return idDoctor;
    }

    public ArrayList<String> getSelectedDays() {
        return selectedDays;
    }

    public int getIdScedule(){
        return idScedule;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setIdDoctor(int idDoctor){
        this.idDoctor = idDoctor;
    }

    public void setIdScedule(int idScedule){
        this.idScedule = idScedule;
    }

    public void setSelectedDays(ArrayList<String> selectedDays) {
        this.selectedDays = selectedDays;
    }

    public static void addNewDoctor(Doctor data){
        doctors.add(data);
    }
    
    static {
        doctors = new ArrayList<>();
    }

}


