package com.app.controlstock.respositories;

import com.app.controlstock.entities.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaJpaRepository extends JpaRepository<VentaEntity, Long> {
}
