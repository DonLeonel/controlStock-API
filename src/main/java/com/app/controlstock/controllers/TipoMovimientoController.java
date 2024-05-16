package com.app.controlstock.controllers;

import com.app.controlstock.dtos.request.ReqTipoMovimientoDTO;
import com.app.controlstock.dtos.response.ResTipoMovimientoDTO;
import com.app.controlstock.services.TipoMovimientoService;
import com.app.controlstock.services.interfaces.ITipoMovimientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiposMovimientos")
public class TipoMovimientoController {
    private final ITipoMovimientoService service;
    public TipoMovimientoController(TipoMovimientoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<ResTipoMovimientoDTO> save(@RequestBody ReqTipoMovimientoDTO DTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(DTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ResTipoMovimientoDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResTipoMovimientoDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
}
