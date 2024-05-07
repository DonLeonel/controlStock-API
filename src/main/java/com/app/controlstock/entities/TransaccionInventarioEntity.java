package com.app.controlstock.entities;

import com.app.controlstock.models.Producto;
import com.app.controlstock.models.TipoMovimiento;
import com.app.controlstock.models.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transaccionesInventario")
public class TransaccionInventarioEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @ManyToOne
    private TipoMovimientoEntity tipoMovimiento;

    @Column
    @ManyToOne
    private UsuarioEntity usuario;
    @Column
    @ManyToOne
    private ProductoEntity producto;

    @Column
    private Integer cantidad;
    @Column
    private Double precioUnitario;
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
