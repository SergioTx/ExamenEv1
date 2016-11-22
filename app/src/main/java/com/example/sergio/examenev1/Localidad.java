package com.example.sergio.examenev1;

/**
 * Created by Sergio on 22/11/2016.
 */

public class Localidad {

    private String idLocalidad, foto, habitantes, superficie, web;

    public Localidad(String idLocalidad, String foto, String habitantes, String superficie, String web) {
        this.idLocalidad = idLocalidad;
        this.foto = foto;
        this.habitantes = habitantes;
        this.superficie = superficie;
        this.web = web;
    }
    public Localidad(){}

    public String getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(String idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(String habitantes) {
        this.habitantes = habitantes;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
