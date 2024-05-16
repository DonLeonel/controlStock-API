package com.app.controlstock.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Rol {
    private Long id;
    private String nombre;
    private String descripcion;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
