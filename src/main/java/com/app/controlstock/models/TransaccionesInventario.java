package com.app.controlstock.models;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TransaccionesInventario {
    private Long id;
    private TipoMovimiento tipoMovimiento;
    private Usuario usuario;
    private Producto producto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double total;
    private String nota;
    private LocalDateTime fechaHora;
}
