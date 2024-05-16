package com.app.controlstock.respositories;

import com.app.controlstock.dtos.response.ResUsuarioDTO;
import com.app.controlstock.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    List<UsuarioEntity> findByNombre(String nombre);
}
