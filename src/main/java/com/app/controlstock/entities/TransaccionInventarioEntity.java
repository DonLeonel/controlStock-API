package com.app.controlstock.entities;

import com.app.controlstock.models.Producto;
import com.app.controlstock.models.TipoMovimiento;
import com.app.controlstock.models.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "transacciones_inventario")
public class TransaccionInventarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = TipoMovimientoEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_movimiento")
    private TipoMovimientoEntity tipoMovimiento;

    @ManyToOne(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne(targetEntity = ProductoEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;

    @Column(nullable = false)
    private Integer cantidad;
    @Column(name = "precioUnitario",nullable = false)
    private Double precioUnitario;
    @Column(nullable = false)
    private Double total;
    @Column
    private String nota;
    @Column(name = "fechaHora",nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaHora;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaCreacion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaActualizacion;
}
