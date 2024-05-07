package com.app.controlstock.respositories;

import com.app.controlstock.entities.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraJpaRepository extends JpaRepository<VentaEntity, Long> {
}
