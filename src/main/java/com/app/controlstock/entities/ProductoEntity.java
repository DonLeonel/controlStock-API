package com.app.controlstock.entities;

import com.app.controlstock.models.Categoria;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "productos")
public class ProductoEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;
    @Column
    private String descripcion;

    @Column
    @ManyToOne
    private CategoriaEntity categoria;

    @Column
    private Integer stock;
    @Column
    private Double precioUnitario;
    @Column
    private Double precioDeCompra;

    @Column
    private LocalDateTime fechaCreacion;
    @Column
    private LocalDateTime fechaActualizacion;
}
