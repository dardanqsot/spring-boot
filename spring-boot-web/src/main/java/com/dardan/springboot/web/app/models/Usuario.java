package com.dardan.springboot.web.app.models;

public class Usuario {

    private String nombre;
    private String apellido;
    private String email;

    public Usuario() {
    }

    public Usuario(String darwin, String quispe, String nissant) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
