package com.app.controlstock.dtos.request;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ReqUsuarioDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Integer rolID;
    private Boolean borrado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
