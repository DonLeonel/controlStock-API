package com.app.controlstock.entities;

import com.app.controlstock.models.Rol;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column
    private String avatar;

    @ManyToOne(targetEntity = RolEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false)
    private RolEntity rol;

    @OneToMany(targetEntity = CompraEntity.class, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<CompraEntity> compras;

    @OneToMany(targetEntity = VentaEntity.class, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<VentaEntity> ventas;

    @OneToMany(targetEntity = TransaccionInventarioEntity.class, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<TransaccionInventarioEntity> transaccionesInventario;

    @OneToMany(targetEntity = HistorialMovimientoInventarioEntity.class, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<HistorialMovimientoInventarioEntity> HistorialMovimientosInventario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaCreacion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaActualizacion;
}
