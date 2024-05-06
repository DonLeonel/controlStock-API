package com.app.controlstock.models;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Venta {
    private Long id;
    private Usuario usuario;
    private Producto producto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double total;
    private FormaDePago formaDePago;
    private String nota;
    private LocalDateTime fechaHora;
}
