package com.app.controlstock.models;

import lombok.Data;

@Data
public class Categoria {
    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean borrado;
}
