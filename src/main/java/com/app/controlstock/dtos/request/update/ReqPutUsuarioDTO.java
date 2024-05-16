package com.app.controlstock.dtos.request.update;

import com.app.controlstock.dtos.response.ResRolDTO;
import com.app.controlstock.models.Rol;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ReqPutUsuarioDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String avatar;
    private Integer rolID;
    private Boolean borrado;

    private LocalDateTime fechaActualizacion;
}
