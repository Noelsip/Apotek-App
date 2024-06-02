package com.tubes11.apotekerreal.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import com.tubes11.apotekerreal.dao.DoctorDAO;
import com.tubes11.apotekerreal.model.Doctor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AddDoctorsController {
    @FXML
    private ImageView bgImgVw;
    @FXML
    private ImageView homeImgView;
    @FXML
    private Button addDoctorButton;
    @FXML
    private Button homeButton;
    @FXML
    private Button dSceduleBackButton;
    @FXML
    private TextField doctorsNameTextField;
    @FXML
    private TextField specialicDoctorTextField;
    @FXML
    private CheckBox monDayCheckBox,tuesDayCheckBox, wedDayCheckBox, thursDayCheckBox, friDayCheckBox;
    @FXML
    private List<CheckBox> checkBoxes;

    private ArrayList<String> jadwal;
    private DoctorDAO doctorDAO;
    
    public AddDoctorsController(){
        doctorDAO = new DoctorDAO();
    }

    @FXML
    // To TextField Controller Doctor Name
    private void doctorsNameTextFieldOnAction(ActionEvent event){
        Stage stage = (Stage) doctorsNameTextField.getScene().getWindow();
        stage.close();
    }
    @FXML
    // To TextField Controller Specialist Doctor Specialic
    private void specialicDoctorTextFieldOnAction(ActionEvent event){
        Stage stage = (Stage) specialicDoctorTextField.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void scheduleCheckBoxOnAction(ActionEvent event){
    checkBoxes = Arrays.asList(monDayCheckBox, tuesDayCheckBox,wedDayCheckBox, thursDayCheckBox, friDayCheckBox);
    jadwal = new ArrayList<>();
    CheckBox checkBox = (CheckBox)  event.getSource();
    String day = checkBox.getText().toLowerCase();

    if (checkBox.isSelected()) {
        System.out.println(day + " Selected");
        jadwal.add(day);
    } else{
        System.out.println(day + " Selected is Cancel");
    }
}

    @FXML
    // Button Home
    private void homeButtonOnAction(ActionEvent event) throws IOException{
        Stage stage = (Stage) homeButton.getScene().getWindow();
    
        stage.close();
    }
    @FXML
    private void addDoctorButtonOnAction(ActionEvent event) throws SQLException{
        String name = doctorsNameTextField.getText();
        String specialization = specialicDoctorTextField.getText();
        ArrayList<String> selectedDays = new ArrayList<>();

        Doctor data = new Doctor(0, 0, name, specialization, "", null, selectedDays);
        
        try{
            DoctorDAO.addDoctor(data);
            JOptionPane.showMessageDialog(null, "JADWAL BERHASIL DITAMBAHKAN", "ADD DOCTOR SCEDULE MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error inserting data: " + e.getMessage(), " Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @FXML
    // Button Back Option Doctor
    private void dSceduleBackButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/docter-page/docter-menu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
