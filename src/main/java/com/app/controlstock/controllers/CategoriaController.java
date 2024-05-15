package com.app.controlstock.controllers;

import com.app.controlstock.models.Categoria;
import com.app.controlstock.services.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriasService service;

    @PostMapping("/save")
    public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCategoria(categoria));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Categoria>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateCategoria(categoria));
    }

}
