package com.tubes11.apotekerreal;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/com/tubes11/apotekerreal/view/page/login.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MAIN");
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}