package com.app.controlstock.respositories;

import com.app.controlstock.entities.HistorialMovimientoInventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialMovimientoInventarioJpaRepository extends JpaRepository<HistorialMovimientoInventarioEntity, Long> {
}
