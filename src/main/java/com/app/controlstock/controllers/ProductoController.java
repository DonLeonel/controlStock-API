package com.app.controlstock.controllers;

import com.app.controlstock.models.Producto;
import com.app.controlstock.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductosService service;

    @PostMapping("/save")
    public ResponseEntity<Producto> saveProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(service.saveProducto(producto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Producto>> getAllProductos(){
        return ResponseEntity.ok(service.getProductos());
    }
}
