package com.proyectoUno.dto.reponse;

import java.util.UUID;

public class UsuarioResponseDTO {

    private UUID id;
    private String nombre;
    private String apellido;
    private String email;
    private String rol;

    //Metodo setter y getter

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

}
