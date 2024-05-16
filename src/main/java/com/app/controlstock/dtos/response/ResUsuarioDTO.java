package com.app.controlstock.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResUsuarioDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String avatar;
    private ResRolDTO rol;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ultimaConexion;
}
