package com.app.controlstock.models;

import lombok.Data;

@Data
public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private Integer stock;
    private Double precioUnitario;
    private Double precioDeCompra;
}
