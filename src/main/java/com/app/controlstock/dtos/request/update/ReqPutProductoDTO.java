package com.app.controlstock.dtos.request.update;

import com.app.controlstock.models.Categoria;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class ReqPutProductoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Integer categoriaID;
    private Integer stock;
    private BigDecimal precioUnitario;
    private BigDecimal precioDeCompra;

    private LocalDateTime fechaActualizacion;
}
