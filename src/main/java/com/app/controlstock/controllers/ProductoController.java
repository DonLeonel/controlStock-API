package com.app.controlstock.controllers;

import com.app.controlstock.dtos.request.ReqProductoDTO;
import com.app.controlstock.dtos.request.ReqPutProductoDTO;
import com.app.controlstock.dtos.response.ResProductoDTO;
import com.app.controlstock.services.ProductosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductosService service;
    public ProductoController(ProductosService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<ResProductoDTO> save(@RequestBody ReqProductoDTO reqProductoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(reqProductoDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ResProductoDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/findByName/{nombre}")
    public ResponseEntity<List<ResProductoDTO>> findByName(@PathVariable String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(service.findByName(nombre));
    }

    @PutMapping("/update")
    public ResponseEntity<ResProductoDTO> update(@RequestBody ReqPutProductoDTO reqPutProductoDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(reqPutProductoDTO));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ResProductoDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
