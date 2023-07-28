package com.conversor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;

public class MainController extends Obtener implements Initializable {

    @FXML
    private ChoiceBox<String> selecMain;

    private final String[] opciones = {"Divisas", "Temperaturas"};
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        selecMain.getItems().addAll(opciones);
        selecMain.setOnAction(arg01 -> {
            try {
                new Obtener(selecMain.getValue());
                App.setRoot("conversor");  
            } catch (IOException e) {
                Alert alert = new Alert(AlertType.ERROR, e.getMessage());
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        });
    }


}
