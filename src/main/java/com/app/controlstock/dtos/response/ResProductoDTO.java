package com.app.controlstock.dtos.response;

import lombok.Data;

@Data
public class ResProductoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private ResCategoriaDTO categoria;
    private Integer stock;
    private Double precioUnitario;
    private Double precioDeCompra;
}
