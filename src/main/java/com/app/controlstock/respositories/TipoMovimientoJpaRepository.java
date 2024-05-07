package com.app.controlstock.respositories;

import com.app.controlstock.entities.TipoMovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoMovimientoJpaRepository extends JpaRepository<TipoMovimientoEntity, Long> {
}
