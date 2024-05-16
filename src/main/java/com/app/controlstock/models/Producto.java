package com.app.controlstock.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private Integer stock;
    private BigDecimal precioUnitario;
    private BigDecimal precioDeCompra;
    private Boolean borrado;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
