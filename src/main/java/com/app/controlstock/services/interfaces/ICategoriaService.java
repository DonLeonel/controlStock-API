package com.app.controlstock.services.interfaces;

import com.app.controlstock.models.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoriaService {

    Categoria saveCategoria(Categoria categoria);
    List<Categoria> getAll();
    Categoria findById(Long id);
    Categoria updateCategoria(Categoria categoria);
    void deleteById(Long id);
}
