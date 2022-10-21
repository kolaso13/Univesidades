package com.example.universidades;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    String nombre;
    String pais;
    String paginaWeb;


    public Universidad(String nombre, String pais, String paginaWeb) {
        this.nombre = nombre;
        this.pais= pais;
        this.paginaWeb = paginaWeb;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String pWeb) {
        this.paginaWeb = pWeb;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
