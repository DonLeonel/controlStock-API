package com.app.controlstock.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "historial_movimientos_inventario")
public class HistorialMovimientoInventarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = TipoMovimientoEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_movimiento", nullable = false)
    private TipoMovimientoEntity tipoMovimiento;

    @ManyToOne(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne(targetEntity = ProductoEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;

    @ManyToOne(targetEntity = CompraEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compra")
    private CompraEntity compra;

    @ManyToOne(targetEntity = VentaEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta")
    private VentaEntity venta;

    @Column(nullable = false)
    private Integer cantidad;
    @Column(name = "precio_unitario",nullable = false)
    private Double precioUnitario;
    @Column(name = "precio_actualizado",nullable = false)
    private Double precioActualizado;
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
