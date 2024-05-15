package com.app.controlstock.respositories;

import com.app.controlstock.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolJpaRepository extends JpaRepository<RolEntity, Long> {
}
