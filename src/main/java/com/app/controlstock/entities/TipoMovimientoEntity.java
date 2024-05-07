package com.app.controlstock.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tiposMoviemientos")
public class TipoMovimientoEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;
    @Column
    private String descripcion;

    @Column
    private LocalDateTime fechaCreacion;
    @Column
    private LocalDateTime fechaActualizacion;
}
