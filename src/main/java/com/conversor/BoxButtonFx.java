package com.conversor;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class BoxButtonFx  {
    
    BoxButtonFx(ComboBox<String> toConversor, ComboBox<String> fromConversor, Button ejecutar, String[] arr){
        // Llenar ComboBox
        toConversor.setItems(FXCollections.observableArrayList(arr));
        fromConversor.setItems(FXCollections.observableArrayList(arr));

        // Eventos buscar
        toConversor.setOnKeyReleased(event -> toConversor.getItems().setAll(findMatchingOptions(toConversor.getEditor().getText(), arr)));
        fromConversor.setOnKeyReleased(event -> fromConversor.getItems().setAll(findMatchingOptions(fromConversor.getEditor().getText(), arr)));

        // Cambiar el color del botón a rojo cuando el mouse entre en el botón
        ejecutar.setOnMouseEntered(e -> ejecutar.setStyle("-fx-background-color: #48cae4;"));
        // Restaurar el color original del botón cuando el mouse salga del botón
        ejecutar.setOnMouseExited(e -> ejecutar.setStyle("-fx-background-color: #000;"));
    }

    String[] findMatchingOptions(String input, String[] arr) {
        // Encuentra las opciones que coinciden con el texto de entrada
        return FXCollections.observableArrayList(arr)
                .filtered(option -> option.toLowerCase().startsWith(input.toLowerCase()))
                .toArray(String[]::new);
    }
}
