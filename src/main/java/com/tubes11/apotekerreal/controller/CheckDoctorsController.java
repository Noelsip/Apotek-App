package com.tubes11.apotekerreal.controller;

import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CheckDoctorsController {
    @FXML
    private ImageView sceduleImgView;
    @FXML
    private CheckBox checkBoxMonday,checkBoxTuesday,checkBoxWednesday,checkBoxThursday,checkBoxFriday;
    @FXML
    private Button backButton;
    @FXML
    private Button homeButton;
    @FXML
    private ImageView imgButtonHome;
    @FXML
    private ChoiceBox<String> doctorNameChoiceBox;
    private String[] doctorName = {"Noel", "Anugrah", "Faqih", "Satriya"};
    

    @FXML
    private void initialize1() {
        String file_dir = "/com/tubes11/apotekerreal/img/docter_img.jpg";
        File file = new File(file_dir);

        Image bgImage = new Image(file.toURI().toString());
        sceduleImgView.setImage(bgImage);
    }

    @FXML
    private void doctorNameChoiceBoxOnAction(ActionEvent event){
        
        ObservableList<String> doctorName = FXCollections.observableArrayList();
        doctorName.addAll(this.doctorName);
        doctorNameChoiceBox.setItems(doctorName);
    }

    @FXML
    public void receiveCheckState(CheckBox checkBoxMonday, CheckBox checkBoxTuesday, CheckBox checkBoxWednesday, CheckBox checkBoxThursday, CheckBox checkBoxFriday){
        this.checkBoxMonday = checkBoxMonday;
        this.checkBoxTuesday = checkBoxTuesday;
        this.checkBoxWednesday = checkBoxWednesday;
        this.checkBoxThursday = checkBoxThursday;
        this.checkBoxFriday = checkBoxFriday;
    }
    @FXML
    private void checkBoxMondayOnAction(){
        if(checkBoxMonday.isSelected()){
            System.out.println("Monday Selected");
        }else{
            System.out.println("Monday Selected is Cancel");
        }
    }
    @FXML
    private void checkBoxTuesdayOnAction(){
        if(checkBoxMonday.isSelected()){
            System.out.println("Tuesday Selected");
        }else{
            System.out.println("Tuesday Selected is Cancel");
        }
    }
    @FXML
    private void checkBoxWednesdayOnAction(){
        if(checkBoxMonday.isSelected()){
            System.out.println("Wednesday Selected");
        }else{
            System.out.println("Wednesday Selected is Cancel");
        }
    }
    @FXML
    private void checkBoxThursdayOnAction(){
        if(checkBoxMonday.isSelected()){
            System.out.println("Thursday Selected");
        }else{
            System.out.println("Thursday Selected is Cancel");
        }
    }
    @FXML
    private void checkBoxFridayOnAction(){
        if(checkBoxMonday.isSelected()){
            System.out.println("Friday Selected");
        }else{
            System.out.println("Friday Selected is Cancel");
        }
    }
    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/docter-page/docter-menu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        String file_dir = "/com/tubes11/apotekerreal/img/home.jpg";
        File file = new File(file_dir);

        Image bgImage = new Image(file.toURI().toString());
        imgButtonHome.setImage(bgImage);
    }
    @FXML
    private void homeButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/page/home.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
