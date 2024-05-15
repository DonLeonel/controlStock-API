package com.app.controlstock.models;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private Integer stock;
    private Double precioUnitario;
    private Double precioDeCompra;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
