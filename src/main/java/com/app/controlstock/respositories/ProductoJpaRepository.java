package com.app.controlstock.respositories;

import com.app.controlstock.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoJpaRepository extends JpaRepository<ProductoEntity, Long> {

    public List<ProductoEntity> findByNombre(String name);
}
