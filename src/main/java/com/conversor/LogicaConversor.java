package com.conversor;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public abstract class LogicaConversor extends BoxButtonFx {

    LogicaConversor(ComboBox<String> toConversor, ComboBox<String> fromConversor, Button ejecutar, String[] divisas) {
        super(toConversor, fromConversor, ejecutar, divisas);
    }

    public abstract String valorConversor(double valor, String to, String from);

     TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
            String input = change.getText();
            if (input.matches("\\d*")) {
                return change;
            } else {
                // Si se intenta ingresar algo que no es un número, se rechaza el cambio
                Alert alert = new Alert(AlertType.ERROR, "Solo números");
                alert.setHeaderText(null);
                alert.showAndWait();
                return null;
            }
        });

    public abstract void AccionButton(Button ejecutar, String[] divisas, ComboBox<String> toConversor, ComboBox<String> fromConversor, TextField valor, Label resultado);

    
}
