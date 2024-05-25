module com.tubes11.apotekerreal {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires MaterialFX;
    requires javafx.base;
    requires java.desktop;

//    exports com.example.material;
    opens com.tubes11.apotekerreal to javafx.fxml;
    exports com.tubes11.apotekerreal;
    exports com.tubes11.apotekerreal.controller;
    opens com.tubes11.apotekerreal.controller to javafx.fxml;
}