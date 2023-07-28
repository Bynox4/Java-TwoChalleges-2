package com.conversor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Temperaturas extends LogicaConversor  {

    Temperaturas(ComboBox<String> toConversor, ComboBox<String> fromConversor, Button ejecutar, TextField valor, Label resultado, String[] temperaturas) {
        // Llenar ComboBox & Eventos buscar
        super(toConversor, fromConversor, ejecutar, temperaturas);

        // Validación Solo números
        valor.setTextFormatter(textFormatter);

         // Accion boton ejecutar
        AccionButton(ejecutar, temperaturas, toConversor, fromConversor, valor, resultado);
    }


    
    @Override
    public String valorConversor(double valor, String to, String from) {
        String combinadoString = from + " " + to;
        int decimales = 3;
        Map<String, String> combinacionesARespuestas = new HashMap<>();
        combinacionesARespuestas.put("Celsius Kelvin", Double.toString(Math.round((valor + 273.15)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°K");
        combinacionesARespuestas.put("Celsius Fahrenheit", Double.toString(Math.round((valor * 1.8000 + 32.00)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°F");
        combinacionesARespuestas.put("Celsius Reaumur", Double.toString(Math.round((valor * 4/5)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°Re");
        combinacionesARespuestas.put("Celsius Rankine", Double.toString(Math.round(((valor + 273.15 ) * 9/5)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°R");

        combinacionesARespuestas.put("Kelvin Celsius", Double.toString(Math.round((valor - 273.15)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°C");
        combinacionesARespuestas.put("Kelvin Fahrenheit", Double.toString(Math.round(((valor - 273.15) * 1.8000 + 32.00)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°F");
        combinacionesARespuestas.put("Kelvin Reaumur", Double.toString(Math.round(((valor - 273.15) * 0.80000)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°Re");
        combinacionesARespuestas.put("Kelvin Rankine", Double.toString(Math.round((valor * 9/5)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°R");

        combinacionesARespuestas.put("Fahrenheit Celsius", Double.toString(Math.round(((valor - 32) / 1.8000)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°C");
        combinacionesARespuestas.put("Fahrenheit Kelvin", Double.toString(Math.round(((valor - 32) / 1.8000 + 273.15)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°K");
        combinacionesARespuestas.put("Fahrenheit Reaumur", Double.toString(Math.round(((valor - 32) * 4/9)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°Re");
        combinacionesARespuestas.put("Fahrenheit Rankine", Double.toString(Math.round((valor + 459.67)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°R");

        combinacionesARespuestas.put("Reaumur Celsius", Double.toString(Math.round((valor * 5/4)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°C");
        combinacionesARespuestas.put("Reaumur Kelvin", Double.toString(Math.round(((valor+ 273.15) * (5/4))* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°K");
        combinacionesARespuestas.put("Reaumur Fahrenheit", Double.toString(Math.round((valor * 9/4 + 32)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°F");
        combinacionesARespuestas.put("Reaumur Rankine", Double.toString(Math.round((valor * 2.2500 + 491.67)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°R");

        combinacionesARespuestas.put("Rankine Celsius", Double.toString(Math.round(((valor  - 491.67) * 5/9)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°C");
        combinacionesARespuestas.put("Rankine Kelvin", Double.toString(Math.round((valor * 5/9)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°K");
        combinacionesARespuestas.put("Rankine Fahrenheit", Double.toString(Math.round((valor - 459.67)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°F");
        combinacionesARespuestas.put("Rankine Reaumur", Double.toString(Math.round(((valor - 491.67) * 0.44444)* Math.pow(10, decimales)) / Math.pow(10, decimales)) + "°Re");

        return combinacionesARespuestas.getOrDefault(combinadoString, "Combinación no válida");
    }



    @Override
    public void AccionButton(Button ejecutar, String[] temperaturas, ComboBox<String> toConversor,
            ComboBox<String> fromConversor, TextField valor, Label resultado) {
        ejecutar.setOnAction(e -> {
            List<String> arr = Arrays.asList(temperaturas);
            String valorTo = toConversor.getEditor().getText();
            String valorFrom = fromConversor.getEditor().getText();
            if (valor.getLength() > 0 && arr.contains(valorTo) && arr.contains(valorFrom) && !valorTo.equalsIgnoreCase(valorFrom)) {
                Double valordouble = Double.parseDouble(valor.getText());
                resultado.setText(valorConversor(valordouble, valorTo, valorFrom));
                valor.setText("");
            } else {
                Alert alert = new Alert(AlertType.ERROR, "Por favor complete la información o/y selecione opciones diferentes");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        });
    }

    
    
}
