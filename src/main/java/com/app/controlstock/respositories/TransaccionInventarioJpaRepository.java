package com.app.controlstock.respositories;

import com.app.controlstock.entities.TransaccionInventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionInventarioJpaRepository extends JpaRepository<TransaccionInventarioEntity, Long> {
}
