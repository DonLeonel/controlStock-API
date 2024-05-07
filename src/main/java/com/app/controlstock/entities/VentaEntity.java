package com.app.controlstock.entities;

import com.app.controlstock.models.FormaDePago;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ventas")
public class VentaEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private FormaDePago formaDePago;
    @Column
    private String nota;
    @Column
    private LocalDateTime fechaHora;

    @Column
    private LocalDateTime fechaCreacion;
    @Column
    private LocalDateTime fechaActualizacion;
}
