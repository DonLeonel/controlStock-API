package com.app.controlstock.services;


import com.app.controlstock.dtos.request.ReqRolDTO;
import com.app.controlstock.dtos.response.ResRolDTO;
import com.app.controlstock.entities.RolEntity;
import com.app.controlstock.exceptions.NotFoundException;
import com.app.controlstock.respositories.RolJpaRepository;
import com.app.controlstock.services.interfaces.IRolService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class RolService implements IRolService {

    private final RolJpaRepository repository;
    private final ModelMapper modelMapper;

    public RolService(RolJpaRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResRolDTO save(ReqRolDTO reqRolDTO) {
        reqRolDTO.setFechaCreacion(LocalDateTime.now());
        reqRolDTO.setFechaActualizacion(LocalDateTime.now());
        return mapToResDTO(repository.save(mapToEntity(reqRolDTO)));
    }

    @Override
    public List<ResRolDTO> getAll() {
        return repository.findAll().stream().map(this::mapToResDTO).toList();
    }

    @Override
    public ResRolDTO findById(Long id) {
        RolEntity rolEntity = repository.findById(id).orElseThrow(
                () -> new NotFoundException("No se encontro el Rol."));
        return mapToResDTO(rolEntity);
    }

    private ResRolDTO mapToResDTO(RolEntity entity){
        return this.modelMapper.map(entity, ResRolDTO.class);
    }
    private RolEntity mapToEntity(ReqRolDTO DTO){
        return this.modelMapper.map(DTO, RolEntity.class);
    }
}
