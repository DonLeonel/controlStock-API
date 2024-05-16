package com.app.controlstock.services;

import com.app.controlstock.dtos.request.ReqProductoDTO;
import com.app.controlstock.dtos.request.ReqPutProductoDTO;
import com.app.controlstock.dtos.response.ResProductoDTO;
import com.app.controlstock.entities.ProductoEntity;
import com.app.controlstock.exceptions.NotFoundException;
import com.app.controlstock.respositories.ProductoJpaRepository;
import com.app.controlstock.services.interfaces.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductosService implements IProductoService {

    private final ProductoJpaRepository productoJpaRepository;
    private final ModelMapper modelMapper;
    private final ModelMapper mergerMapper;
    public ProductosService(ProductoJpaRepository productoJpaRepository, ModelMapper modelMapper, ModelMapper mergerMapper) {
        this.productoJpaRepository = productoJpaRepository;
        this.modelMapper = modelMapper;
        this.mergerMapper = mergerMapper;
    }

    @Override
    public ResProductoDTO save(ReqProductoDTO reqProductoDTO) {
        reqProductoDTO.setFechaCreacion(LocalDateTime.now());
        reqProductoDTO.setFechaActualizacion(LocalDateTime.now());
        reqProductoDTO.setBorrado(false);
        return mapToResDTO(productoJpaRepository.save(mapToEntity(reqProductoDTO)));
    }

    @Override
    public List<ResProductoDTO> getAll() {
        return productoJpaRepository.findAll().stream()
                .filter(p -> p.getBorrado().equals(false))
                .map(this::mapToResDTO)
                .toList();
    }

    @Override
    public List<ResProductoDTO> findByName(String name) {
        return productoJpaRepository.findByNombre(name).stream()
                .filter(p -> p.getBorrado().equals(false))
                .map(this::mapToResDTO)
                .toList();
    }

    @Override
    public ResProductoDTO findById(Long id) {
        ProductoEntity productoEntity = productoJpaRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("No se encontro el producto."));
        return mapToResDTO(productoEntity);
    }

    @Override
    public ResProductoDTO update(ReqPutProductoDTO reqPutProductoDTO) {
        findById(reqPutProductoDTO.getId());
        ProductoEntity productoEntity = productoJpaRepository.getReferenceById(reqPutProductoDTO.getId());
        productoEntity.setFechaActualizacion(LocalDateTime.now());
        mergerMapper.map(reqPutProductoDTO, productoEntity);
        return mapToResDTO(productoJpaRepository.save(productoEntity));
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        ProductoEntity productoEntity = productoJpaRepository.getReferenceById(id);
        productoEntity.setBorrado(true);
        productoEntity.setFechaActualizacion(LocalDateTime.now());
        productoJpaRepository.save(productoEntity);
    }

    private ResProductoDTO mapToResDTO(ProductoEntity ProductoEntity){
        return this.modelMapper.map(ProductoEntity, ResProductoDTO.class);
    }

    private ProductoEntity mapToEntity(ReqProductoDTO reqProductoDTO){
        return this.modelMapper.map(reqProductoDTO, ProductoEntity.class);
    }
}
