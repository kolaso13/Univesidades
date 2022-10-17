package com.example.universidades;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    String nombre, pais, paginaWeb;
    static List<Universidad> ListaUniversidades = new ArrayList<>();

    public Universidad(String nombre, String pais, String paginaWeb) {
        this.nombre = nombre;
        this.pais= pais;
        this.paginaWeb = paginaWeb;
    }

    public static void addUniversidad(Universidad uni){
        ListaUniversidades.add(uni);
    }

    public static List<Universidad> getLista(){
        return ListaUniversidades;
    }

    public String getPais() {
        return pais;
    }


}
