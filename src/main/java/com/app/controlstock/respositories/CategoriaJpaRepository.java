package com.app.controlstock.respositories;

import com.app.controlstock.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, Long> {
}
