package com.app.controlstock.respositories;

import com.app.controlstock.entities.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaJpaRepository extends JpaRepository<VentaEntity, Long> {
}
