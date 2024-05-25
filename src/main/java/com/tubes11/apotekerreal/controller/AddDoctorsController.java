package com.tubes11.apotekerreal.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tubes11.apotekerreal.model.DoctorInput;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AddDoctorsController {
    private ArrayList<String> jadwal = new ArrayList<>();
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
    private CheckBox monDayCheckBox;
    @FXML
    private CheckBox tuesDayCheckBox;
    @FXML
    private CheckBox wedDayCheckBox;
    @FXML
    private CheckBox thursDayCheckBox;
    @FXML
    private CheckBox friDayCheckBox;
    


    @FXML
    // To show the Image BackGround
    private void initialize(){
        String file_dir = "/com/tubes11/apotekerreal/img/apotek_try2.jpg";
        File file = new File(file_dir);

        Image bgImage = new Image(file.toURI().toString());
        bgImgVw.setImage(bgImage);
    }
    @FXML
    // Button Home
    private void homeButtonOnAction(ActionEvent event) throws IOException{
        CheckDoctorsController checkDoctors = new CheckDoctorsController();
        checkDoctors.receiveCheckState(wedDayCheckBox, tuesDayCheckBox, thursDayCheckBox, monDayCheckBox, friDayCheckBox);
        
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/com/tubes11/apotekerreal/view/page/home.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) homeButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
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
    private void monDayCheckBoxOnAction(ActionEvent event){
        if(monDayCheckBox.isSelected()){
            System.out.println("Monday Selected");
            this.jadwal.add("monday");
            
        }else{
            System.out.println("Monday Selected is Cancel");
            this.jadwal.remove("monday");
        }
    }
    @FXML
    private void tuesDayCheckBoxOnAction(ActionEvent event){
        if(tuesDayCheckBox.isSelected()){
            System.out.println("Tuesday Selected");
            this.jadwal.add("tuesday");
        }else{
            System.out.println("Tuesday Selected is Cancel");
            this.jadwal.remove("tuesday");
        }
    }
    @FXML
    private void wedDayCheckBoxOnAction(ActionEvent event){
        if(wedDayCheckBox.isSelected()){
            System.out.println("Wednesday Selected");
            this.jadwal.add("wednesday");
        }else{
            System.out.println("Wednesday Selected is Cancel");
            this.jadwal.remove("wednesday");
        }
    }
    @FXML
    private void thursDayCheckBoxOnAction(ActionEvent event){
        if(thursDayCheckBox.isSelected()){
            System.out.println("Thursday Selected");
            this.jadwal.add("thursday");
        }else{
            System.out.println("Thursday Selected is Cancel");
            this.jadwal.remove("thursday");
        }
    }
    @FXML
    private void friDayCheckBoxOnAction(ActionEvent event){
        if(friDayCheckBox.isSelected()){
            System.out.println("Friday Selected");
            this.jadwal.add("friday");
        } else{
            System.out.println("Friday Selected is Cancel");
            this.jadwal.remove("friday");
        }
    }

    @FXML
    //To MESSAGE AFTER BUTTON ADD IN ACTION
    private void addDoctorButtonOnAction(ActionEvent event){
        String name = doctorsNameTextField.getText();
        String address = specialicDoctorTextField.getText();
        DoctorInput data = new DoctorInput(
            name, address, this.jadwal
        );
        DoctorInputDAO.addNewDocter(data);
        JOptionPane.showMessageDialog(null, "JADWAL BERHASIL DITAMBAHKAN", "ADD DOCTOR SCEDULE MESSAGE", JOptionPane.INFORMATION_MESSAGE);
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
