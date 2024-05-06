package com.app.controlstock.models;

import lombok.Data;

@Data
public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String avatar;
    private Rol rol;
}
