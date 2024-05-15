package com.app.controlstock.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;

    @ManyToOne(targetEntity = CategoriaEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaEntity categoria;

    @ManyToMany(targetEntity = VentaEntity.class, fetch = FetchType.LAZY)
    @JoinTable(name = "productos_ventas",
            joinColumns = @JoinColumn(name = "producto"),
            inverseJoinColumns = @JoinColumn(name = "venta"))
    private List<VentaEntity> ventas;

    @ManyToMany(targetEntity = CompraEntity.class, fetch = FetchType.LAZY)
    @JoinTable(name = "productos_compras",
            joinColumns = @JoinColumn(name = "producto"),
            inverseJoinColumns = @JoinColumn(name = "compra"))
    private List<CompraEntity> compras;

    @OneToMany(targetEntity = HistorialMovimientoInventarioEntity.class, fetch = FetchType.LAZY, mappedBy = "producto")
    private List<HistorialMovimientoInventarioEntity> historialMovimientosInventario;

    @OneToMany(targetEntity = TransaccionInventarioEntity.class, fetch = FetchType.LAZY, mappedBy = "producto")
    private List<TransaccionInventarioEntity> transaccionesInventario;

    @Column(nullable = false)
    private Integer cantidad;
    @Column( name = "precio_unitario",nullable = false)
    private Double precioUnitario;
    @Column(name = "precio_de_compra")
    private Double precioDeCompra;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaCreacion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime fechaActualizacion;
}
