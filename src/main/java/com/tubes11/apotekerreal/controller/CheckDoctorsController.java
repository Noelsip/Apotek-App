package com.tubes11.apotekerreal.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.tubes11.apotekerreal.dao.DoctorDAO;
import com.tubes11.apotekerreal.model.Doctor;
import com.tubes11.apotekerreal.model.Jadwal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class CheckDoctorsController {
    @FXML
    private Button homeButton, backButton;
    @FXML
    private ComboBox<String> doctorNameComboBox;
    @FXML
    private CheckBox seninCheckBox, selasaCheckBox, rabuCheckBox, kamisCheckBox, jumatCheckBox;
    @FXML
    private TableView<Jadwal> jadwalTableView;
    @FXML
    private TableColumn<Jadwal, String> jadwalColumn;
    @FXML
    private TableColumn<Jadwal, CheckBox> checkBoxColumn;

    private DoctorDAO doctorDAO;
    private ObservableList<String> doctorNames;

    public CheckDoctorsController() {
        doctorDAO = new DoctorDAO();
        doctorNames = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        doctorNameComboBox.setItems(doctorNames);
        loadDoctorNames();

    }

    private void loadDoctorNames() {
        try {
            List<Doctor> doctors = doctorDAO.getAllDoctors();
            for (Doctor doctor : doctors) {
                doctorNames.add(doctor.getDoctorName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleDoctorNameComboBoxAction() {
        String selectedDoctorName = doctorNameComboBox.getSelectionModel().getSelectedItem();
        if (selectedDoctorName != null) {
            Doctor selectedDoctor = null;
            try {
                selectedDoctor = doctorDAO.getDoctorByName(selectedDoctorName);
                selectedDoctor.setSelected(true); // Set the selected field to true
                System.out.println("Doctor name: " + selectedDoctor.getDoctorName());
                String doctorSchedule = selectedDoctor.getDoctorScedule();
                System.out.println("Doctor schedule: " + doctorSchedule);
                checkCheckboxes(doctorSchedule);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkCheckboxes(String doctorScedule) {
        String[] days = doctorScedule.split(",");
        clearCheckboxes();
        for (String day : days) {
            switch (day) {
                case "Senin":
                    seninCheckBox.setSelected(isDaySelectedInJadwal(true));
                    break;
                case "Selasa":
                    selasaCheckBox.setSelected(isDaySelectedInJadwal(true));
                    break;
                case "Rabu":
                    rabuCheckBox.setSelected(isDaySelectedInJadwal(true));
                    break;
                case "Kamis":
                    kamisCheckBox.setSelected(isDaySelectedInJadwal(true));
                    break;
                case "Jumat":
                    jumatCheckBox.setSelected(isDaySelectedInJadwal(true));
                    break;
            }
        }
    }

    private boolean isDaySelectedInJadwal(boolean b) {
        // TODO Auto-generated method stub
        
        throw new UnsupportedOperationException("Unimplemented method 'isDaySelectedInJadwal'");
    }

    private void clearCheckboxes() {
        seninCheckBox.setSelected(false);
        selasaCheckBox.setSelected(false);
        rabuCheckBox.setSelected(false);
        kamisCheckBox.setSelected(false);
        jumatCheckBox.setSelected(false);
    }

    @FXML
    private void homeButtonOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage) homeButton.getScene().getWindow();
    
        stage.close();
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/com/tubes11/apotekerreal/view/docter-page/docter-menu.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) homeButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}