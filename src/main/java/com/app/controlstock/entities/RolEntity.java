package com.app.controlstock.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;
    @Column
    private String descripcion;

    @OneToMany(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY, mappedBy = "rol")
    private List<UsuarioEntity> usuarios;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaCreacion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaActualizacion;
}
