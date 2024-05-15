package com.app.controlstock.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "compras")
@Entity
public class CompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @OneToMany(targetEntity = HistorialMovimientoInventarioEntity.class, fetch = FetchType.LAZY, mappedBy = "compra")
    private List<HistorialMovimientoInventarioEntity> historialMovimientosInventario;

    @Column(nullable = false)
    private Integer cantidad;
    @Column(name = "precio_de_compra",nullable = false)
    private Double precioDeCompra;
    @Column(nullable = false)
    private Double total;
    @Column
    private String nota;
    @Column(name = "fecha_hora",nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaHora;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaCreacion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaActualizacion;
}
