package com.app.controlstock.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Categoria {
    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean borrado;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
