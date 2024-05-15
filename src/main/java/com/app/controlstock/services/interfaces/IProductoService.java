package com.app.controlstock.services.interfaces;

import com.app.controlstock.models.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IProductoService {
    Producto saveProducto(Producto producto);
    List<Producto> getProductos();
    Producto getProductoById(Long id);
    Producto updateProducto(Producto producto);
    Boolean deleteProducto(Long id);
    List<Producto> getProductoByName(String name);
}
