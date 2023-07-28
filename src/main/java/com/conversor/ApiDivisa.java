package com.conversor;

import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ApiDivisa {

    private double porcentaje;

    ApiDivisa(String to, String from){
        try {
            URL url = new URL("https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_MZuHnCPB6q8Hw2RAIjBIBiLoQhYqvV6hFz5pLxA3&currencies=" + to + "&base_currency="+ from);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
     
            conn.setRequestMethod("GET");
            conn.connect();

             int resp = conn.getResponseCode();
             if (resp != 200) {
                throw new RuntimeException("Ocurrio un error: " + resp);
             } else {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(url.openStream());
                this.porcentaje = rootNode.get("data").get(to).asDouble();
             }
        } catch (Exception e) {
             e.printStackTrace();
        }
    }


    public double getPorcentaje(){
        return this.porcentaje;
    }
}

