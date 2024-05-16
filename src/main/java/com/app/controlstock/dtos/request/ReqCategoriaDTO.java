package com.app.controlstock.dtos.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReqCategoriaDTO {
    private String nombre;
    private String descripcion;
    private Boolean borrado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
