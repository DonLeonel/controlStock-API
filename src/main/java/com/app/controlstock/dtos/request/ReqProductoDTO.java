package com.app.controlstock.dtos.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ReqProductoDTO {
    private String nombre;
    private String descripcion;
    private Integer categoriaID;
    private Integer stock;
    private BigDecimal precioUnitario;
    private BigDecimal precioDeCompra;
    private Boolean borrado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
