package com.app.controlstock.dtos.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReqTipoMovimientoDTO {

    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
