package com.conversor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConversorController extends Obtener implements Initializable {

    @FXML
    public void volver() throws IOException{
        App.setRoot("main");
    }

    @FXML
    private ComboBox<String> toConversor;

    @FXML
    private ComboBox<String> fromConversor;

    @FXML
    private TextField valor;

    @FXML
    private Button ejecutar;

    @FXML
    private Label resultado;

    private final String[] divisas = {"Dolar Australiano", "Lev Búlgaro", "Real Brasileño", "Dolar Canadiense", "Franco Suizo", "Renminbi", "Corona Checa", "Corona Danesa", "Euro", "Libra Esterlina", "Dolar de Hong Kong", "Kuna Croata", "Florín Húngaro", "Rupia Indonesia", "Shekel Israelí", "Rupia India", "Corona Islandesa", "Yen Japonés", "Won Surcoreano", "Peso Mexicano", "Ringgit Malasio", "Corona Noruega", "Dolar Neozelandés", "Peso Filipino", "Leu Rumano", "Rublo Ruso", "Corona Sueca", "Dolar Singapur", "Baht Tailandés", "Lira Turca", "Dolar Estadounidense", "Rand Sudafricano"};

    private final String[] temperaturas = {"Celsius", "Kelvin", "Fahrenheit", "Reaumur", "Rankine"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        switch (getChoice()) {
            case "Divisas":
                new Divisas(toConversor, fromConversor, ejecutar, valor, resultado, divisas);
                break;
            case "Temperaturas":
                new Temperaturas(toConversor, fromConversor, ejecutar, valor, resultado, temperaturas);
            break;
        
            default:
                System.err.println("ERROR MAIN");
                break;
        }
    }


}
