package com.app.controlstock.controllers;

import com.app.controlstock.dtos.request.ReqRolDTO;
import com.app.controlstock.dtos.response.ResRolDTO;
import com.app.controlstock.services.RolService;
import com.app.controlstock.services.interfaces.IRolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {
    private final IRolService service;
    public RolController(RolService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<ResRolDTO> save(@RequestBody ReqRolDTO DTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(DTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ResRolDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResRolDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
}
