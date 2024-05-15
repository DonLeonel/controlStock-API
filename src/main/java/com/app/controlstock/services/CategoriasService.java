package com.app.controlstock.services;

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
    public Categoria saveCategoria(Categoria categoria) {
        if(categoria == null) return null;
        CategoriaEntity categoriaEntity = categoriaJpaRepository.save(setFechas(mapToEntity(categoria)));
        return mapToModel(categoriaEntity);
    }

    @Override
    public List<Categoria> getAll() {
       return categoriaJpaRepository.findAll().stream().filter(e -> e.getBorrado().equals(false))
                .map(this::mapToModel)
                .toList();
    }

    @Override
    public Categoria findById(Long id) {
        CategoriaEntity categoriaEntity = categoriaJpaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No se encontro la Categoria."));
        return mapToModel(categoriaEntity);
    }

    @Override
    public Categoria updateCategoria(Categoria categoria) {
        CategoriaEntity categoriaEntity = categoriaJpaRepository.getReferenceById(categoria.getId());
        mergerMapper.map(categoria, setFechaUpdate(categoriaEntity));
        return mapToModel(categoriaJpaRepository.save(categoriaEntity));
    }

    @Override
    public void deleteById(Long id) {
        CategoriaEntity categoriaEntity = categoriaJpaRepository.getReferenceById(id);
        categoriaEntity.setBorrado(true);
        categoriaJpaRepository.save(setFechaUpdate(categoriaEntity));
    }

    private Categoria mapToModel(CategoriaEntity categoriaEntity){
        return this.modelMapper.map(categoriaEntity, Categoria.class);
    }
    private CategoriaEntity mapToEntity(Categoria categoria){
        return this.modelMapper.map(categoria, CategoriaEntity.class);
    }

    private CategoriaEntity setFechas(CategoriaEntity categoriaEntity){
        categoriaEntity.setFechaCreacion(LocalDateTime.now());
        categoriaEntity.setFechaActualizacion(LocalDateTime.now());
        return categoriaEntity;
    }

    private CategoriaEntity setFechaUpdate(CategoriaEntity categoriaEntity){
        categoriaEntity.setFechaActualizacion(LocalDateTime.now());
        return categoriaEntity;
    }
}
