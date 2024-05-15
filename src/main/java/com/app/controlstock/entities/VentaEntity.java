package com.app.controlstock.entities;

import com.app.controlstock.models.FormaDePago;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@Table(name = "ventas")
public class VentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @OneToMany(targetEntity = HistorialMovimientoInventarioEntity.class, fetch = FetchType.LAZY, mappedBy = "venta")
    private List<HistorialMovimientoInventarioEntity> historialMovimientosInventario;

    @Column(nullable = false)
    private Integer cantidad;
    @Column(name = "precio_unitario",nullable = false)
    private Double precioUnitario;
    @Column(nullable = false)
    private Double total;
    @Column(name = "forma_de_pago",nullable = false)
    private FormaDePago formaDePago;
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
