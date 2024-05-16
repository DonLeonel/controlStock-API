package com.app.controlstock.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class Venta {
    private Long id;
    private Usuario usuario;
    private Producto producto;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal total;
    private FormaDePago formaDePago;
    private String nota;
    private LocalDateTime fechaHora;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
