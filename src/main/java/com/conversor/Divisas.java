package com.conversor;

import java.util.Arrays;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Divisas extends LogicaConversor{

    private final String[] APIDivisas = {"AUD", "BGN", "BRL", "CAD", "CHF", "CNY", "CZK", "DKK", "EUR", "GBP", "HKD", "HRK", "HUF", "IDR", "ILS", "INR", "ISK", "JPY", "KRW", "MXN", "MYR", "NOK", "NZD", "PHP", "RON", "RUB", "SEK", "SGD", "THB", "TRY", "USD", "ZAR"};

    
    Divisas(ComboBox<String> toConversor, ComboBox<String> fromConversor, Button ejecutar, TextField valor, Label resultado, String[] divisas) {
        
        // Llenar ComboBox & Eventos buscar
        super(toConversor, fromConversor, ejecutar, divisas);

        // Validación Solo números
        valor.setTextFormatter(textFormatter);

         // Accion boton ejecutar
        AccionButton(ejecutar, divisas, toConversor, fromConversor, valor, resultado);
    }


    @Override
    public String valorConversor(double valor, String to, String from) {
        double valortotal = 0;
        ApiDivisa ApiPorcentaje = new ApiDivisa(to, from);
        int decimales = 3;
        valortotal = Math.round((ApiPorcentaje.getPorcentaje() * valor) * Math.pow(10, decimales)) / Math.pow(10, decimales);
        return Double.toString(valortotal);
    }

    // Ayuda a obtener el indice para compararlo con el arr APIDivisas para que tiene la misma logitud y estan en el mismo orden
    private int obtenerIndice(String[] arr, String buscar){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(buscar)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public void AccionButton(Button ejecutar, String[] divisas, ComboBox<String> toConversor, ComboBox<String> fromConversor, TextField valor, Label resultado) {
        
        ejecutar.setOnAction(e -> {
            List<String> arr = Arrays.asList(divisas);
            String valorTo = toConversor.getEditor().getText();
            String valorFrom = fromConversor.getEditor().getText();
            if (valor.getLength() > 0 && arr.contains(valorTo) && arr.contains(valorFrom) && !valorTo.equalsIgnoreCase(valorFrom)) {
                Double valordouble = Double.parseDouble(valor.getText());
                int indiceTo = obtenerIndice(divisas, toConversor.getEditor().getText());
                int indiceFrom = obtenerIndice(divisas, fromConversor.getEditor().getText());
                resultado.setText(valorConversor(valordouble, APIDivisas[indiceTo], APIDivisas[indiceFrom]));
                valor.setText("");
            } else {
                Alert alert = new Alert(AlertType.ERROR, "Por favor complete la información o/y selecione opciones diferentes");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        });
    }

}
