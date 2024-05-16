package com.app.controlstock.services;

import com.app.controlstock.dtos.request.ReqCategoriaDTO;
import com.app.controlstock.dtos.response.ResCategoriaDTO;
import com.app.controlstock.exceptions.NotFoundException;
import com.app.controlstock.entities.CategoriaEntity;
import com.app.controlstock.models.Categoria;
import com.app.controlstock.respositories.CategoriaJpaRepository;
import com.app.controlstock.services.interfaces.ICategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoriasService implements ICategoriaService {
    private final CategoriaJpaRepository categoriaJpaRepository;
    private final ModelMapper modelMapper;
    private final ModelMapper mergerMapper;

    public CategoriasService(CategoriaJpaRepository categoriaJpaRepository, ModelMapper modelMapper, ModelMapper mergerMapper){
        this.categoriaJpaRepository = categoriaJpaRepository;
        this.modelMapper = modelMapper;
        this.mergerMapper = mergerMapper;
    }

    @Override
    public ResCategoriaDTO save(ReqCategoriaDTO reqCategoriaDTO) {
        reqCategoriaDTO.setFechaCreacion(LocalDateTime.now());
        reqCategoriaDTO.setFechaActualizacion(LocalDateTime.now());
        reqCategoriaDTO.setBorrado(false);
        CategoriaEntity categoriaEntity = categoriaJpaRepository.save(mapToEntity(reqCategoriaDTO));
        return mapToDTO(categoriaEntity);
    }

    @Override
    public List<ResCategoriaDTO> getAll() {
       return categoriaJpaRepository.findAll().stream().filter(e -> e.getBorrado().equals(false))
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public ResCategoriaDTO findById(Long id) {
        CategoriaEntity categoriaEntity = categoriaJpaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No se encontro la Categoria."));
        return mapToDTO(categoriaEntity);
    }

    @Override
    public ResCategoriaDTO update(Categoria categoria) {
        CategoriaEntity categoriaEntity = categoriaJpaRepository.getReferenceById(categoria.getId());
        categoriaEntity.setFechaActualizacion(LocalDateTime.now());
        mergerMapper.map(categoria, categoriaEntity);
        return mapToDTO(categoriaJpaRepository.save(categoriaEntity));
    }

    @Override
    public void deleteById(Long id) {
        CategoriaEntity categoriaEntity = categoriaJpaRepository.getReferenceById(id);
        categoriaEntity.setBorrado(true);
        categoriaEntity.setFechaActualizacion(LocalDateTime.now());
        categoriaJpaRepository.save(categoriaEntity);
    }

    private ResCategoriaDTO mapToDTO(CategoriaEntity categoriaEntity){
        return this.modelMapper.map(categoriaEntity, ResCategoriaDTO.class);
    }
    private CategoriaEntity mapToEntity(ReqCategoriaDTO reqCategoriaDTO){
        return this.modelMapper.map(reqCategoriaDTO, CategoriaEntity.class);
    }
}
