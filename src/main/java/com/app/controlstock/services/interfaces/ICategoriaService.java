package com.app.controlstock.services.interfaces;

import com.app.controlstock.dtos.request.ReqCategoriaDTO;
import com.app.controlstock.dtos.response.ResCategoriaDTO;
import com.app.controlstock.models.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoriaService {
    ResCategoriaDTO save(ReqCategoriaDTO reqCategoriaDTO);
    List<ResCategoriaDTO> getAll();
    ResCategoriaDTO findById(Long id);
    ResCategoriaDTO update(Categoria categoria);
    void deleteById(Long id);
}
