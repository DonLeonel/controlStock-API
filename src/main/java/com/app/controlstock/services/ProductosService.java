package com.app.controlstock.services;

import com.app.controlstock.entities.ProductoEntity;
import com.app.controlstock.models.Producto;
import com.app.controlstock.respositories.ProductoJpaRepository;
import com.app.controlstock.services.interfaces.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductosService implements IProductoService {

    @Autowired
    private ProductoJpaRepository productoJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Producto saveProducto(Producto producto) {
        if(producto == null) return null;
        producto.setFechaCreacion(LocalDateTime.now());
        producto.setFechaActualizacion(LocalDateTime.now());
        ProductoEntity productoEntity = productoJpaRepository.save(modelMapper.map(producto, ProductoEntity.class));
        return modelMapper.map(productoEntity, Producto.class);
    }

    @Override
    public List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();
        List<ProductoEntity> productosEntity = productoJpaRepository.findAll();
        if(productosEntity.size() > 0){
            productosEntity.forEach(p -> productos.add(modelMapper.map(p, Producto.class)));
            return productos;
        }
        else {
            return null;
        }
    }

    @Override
    public Producto getProductoById(Long id) {
        Optional<ProductoEntity> productoEntity = productoJpaRepository.findById(id);
        return modelMapper.map(productoEntity, Producto.class);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        Optional<ProductoEntity> productoEntity = productoJpaRepository.findById(producto.getId());
        if(productoEntity.isPresent()){
           ProductoEntity p = productoJpaRepository.save(modelMapper.map(producto, ProductoEntity.class));
           return modelMapper.map(p, Producto.class);
        }
        else {
            return null;
        }
    }

    @Override
    public Boolean deleteProducto(Long id) {
        return null;
    }

    @Override
    public List<Producto> getProductoByName(String name) {
        return null;
    }
}
