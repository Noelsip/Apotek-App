package com.tubes11.apotekerreal.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.tubes11.apotekerreal.dao.DoctorDAO;
import com.tubes11.apotekerreal.model.Doctor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DeleteDoctorsController {

    @FXML
    private ImageView bgImgVw;

    @FXML
    private Button homeButton;

    @FXML
    private ComboBox<String> doctorComboBox;

    @FXML
    private TextArea textArea;

    @FXML
    private Button deleteButton;

    @FXML
    private Button backButton;

    private DoctorDAO doctorDAO;
    private ObservableList<String> doctorList;

    public DeleteDoctorsController() {
        doctorDAO = new DoctorDAO();
        doctorList = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        try {
            doctorList.addAll(doctorDAO.getAllDoctorsNames());
            doctorComboBox.setItems(doctorList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        textArea.clear();
    }

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/com/tubes11/apotekerreal/view/docter-page/docter-menu.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) homeButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void deleteButtonOnAction(ActionEvent event) {
        String selectedDoctor = doctorComboBox.getSelectionModel().getSelectedItem();
        if (selectedDoctor!= null) {
            try {
                Doctor doctor = doctorDAO.getDoctorByName(selectedDoctor);
                if (doctor!= null) {
                    doctorDAO.deleteDoctor(doctor);
                    doctorComboBox.getItems().remove(selectedDoctor);
                    textArea.clear();
                    int option = JOptionPane.OK_OPTION;
                    JOptionPane.showMessageDialog(null, "JADWAL BERHASIL DITAMBAHKAN", "ADD DOCTOR SCEDULE MESSAGE", option);
                    System.exit(0); // or ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error deleting data: " + e.getMessage(), " Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @FXML
    private void homeButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) homeButton.getScene().getWindow();
    
        stage.close();
    }
}