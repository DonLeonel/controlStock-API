package com.app.controlstock.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "tiposMovimientos")
public class TipoMovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = HistorialMovimientoInventarioEntity.class, fetch = FetchType.LAZY, mappedBy = "tipoMovimiento")
    private List<HistorialMovimientoInventarioEntity> historialMovimientosInventario;

    @OneToMany(targetEntity = TransaccionInventarioEntity.class, fetch = FetchType.LAZY, mappedBy = "tipoMovimiento")
    private List<TransaccionInventarioEntity> transaccionesInventario;

    @Column
    private String nombre;
    @Column
    private String descripcion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaCreacion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaActualizacion;
}
