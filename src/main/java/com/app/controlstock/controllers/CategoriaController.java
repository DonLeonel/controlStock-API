package com.app.controlstock.controllers;

import com.app.controlstock.dtos.request.ReqCategoriaDTO;
import com.app.controlstock.dtos.response.ResCategoriaDTO;
import com.app.controlstock.models.Categoria;
import com.app.controlstock.services.CategoriasService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriasService service;
    public CategoriaController(CategoriasService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<ResCategoriaDTO> save(@RequestBody ReqCategoriaDTO reqCategoriaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(reqCategoriaDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ResCategoriaDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResCategoriaDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<ResCategoriaDTO> update(@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(categoria));
    }

}
