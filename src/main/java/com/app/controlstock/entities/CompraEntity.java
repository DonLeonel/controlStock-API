package com.app.controlstock.entities;

import com.app.controlstock.models.Producto;
import com.app.controlstock.models.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "compras")
@Entity
public class CompraEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @ManyToOne
    private UsuarioEntity usuario;

    @Column
    @ManyToOne
    private ProductoEntity producto;

    @Column
    private Integer cantidad;
    @Column
    private Double precioDeCompra;
    @Column
    private Double total;
    @Column
    private String nota;
    @Column
    private LocalDateTime fechaHora;

    @Column
    private LocalDateTime fechaCreacion;
    @Column
    private LocalDateTime fechaActualizacion;
}
