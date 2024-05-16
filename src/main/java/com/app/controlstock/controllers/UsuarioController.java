package com.app.controlstock.controllers;

import com.app.controlstock.dtos.request.ReqUsuarioDTO;
import com.app.controlstock.dtos.request.update.ReqPutUsuarioDTO;
import com.app.controlstock.dtos.response.ResUsuarioDTO;
import com.app.controlstock.services.UsuarioService;
import com.app.controlstock.services.interfaces.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final IUsuarioService service;
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<ResUsuarioDTO> save(@RequestBody ReqUsuarioDTO reqUsuarioDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(reqUsuarioDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ResUsuarioDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ResUsuarioDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    @GetMapping("/findByName/{nombre}")
    public ResponseEntity<List<ResUsuarioDTO>> findByName(@PathVariable String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(service.findByName(nombre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<ResUsuarioDTO> update(@RequestBody ReqPutUsuarioDTO usuarioDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(usuarioDTO));
    }
}
