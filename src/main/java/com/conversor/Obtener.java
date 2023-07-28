package com.conversor;

public class Obtener {
    
    private static String choice;

    public Obtener(){
    }

    public Obtener(String choice){
        Obtener.choice = choice;
    }

    public String getChoice(){
        return choice;
    }
}
