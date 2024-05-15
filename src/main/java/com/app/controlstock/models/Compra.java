package com.app.controlstock.models;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Compra {
    private Long id;
    private Usuario usuario;
    private Producto producto;
    private Integer cantidad;
    private Double precioDeCompra;
    private Double total;
    private String nota;
    private LocalDateTime fechaHora;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
