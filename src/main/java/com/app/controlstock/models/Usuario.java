package com.app.controlstock.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String avatar;
    private Rol rol;
    private LocalDateTime ultimaConexion;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
