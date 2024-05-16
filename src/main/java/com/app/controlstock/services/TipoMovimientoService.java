package com.app.controlstock.services;

import com.app.controlstock.dtos.request.ReqTipoMovimientoDTO;
import com.app.controlstock.dtos.response.ResTipoMovimientoDTO;
import com.app.controlstock.entities.TipoMovimientoEntity;
import com.app.controlstock.exceptions.NotFoundException;
import com.app.controlstock.respositories.TipoMovimientoJpaRepository;
import com.app.controlstock.services.interfaces.ITipoMovimientoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class TipoMovimientoService implements ITipoMovimientoService {

    private final TipoMovimientoJpaRepository repository;
    private final ModelMapper modelMapper;

    public TipoMovimientoService(TipoMovimientoJpaRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResTipoMovimientoDTO save(ReqTipoMovimientoDTO reqTipoMovimientoDTO) {
        reqTipoMovimientoDTO.setFechaCreacion(LocalDateTime.now());
        reqTipoMovimientoDTO.setFechaActualizacion(LocalDateTime.now());
        return mapToResDTO(repository.save(mapToEntity(reqTipoMovimientoDTO)));
    }

    @Override
    public List<ResTipoMovimientoDTO> getAll() {
        return repository.findAll().stream().map(this::mapToResDTO).toList();
    }

    @Override
    public ResTipoMovimientoDTO findById(Long id) {
        TipoMovimientoEntity Entity = repository.findById(id).orElseThrow(
                () -> new NotFoundException("No se encontro el tipo de Movimiento."));
        return mapToResDTO(Entity);
    }

    private ResTipoMovimientoDTO mapToResDTO(TipoMovimientoEntity entity){
        return this.modelMapper.map(entity, ResTipoMovimientoDTO.class);
    }
    private TipoMovimientoEntity mapToEntity(ReqTipoMovimientoDTO DTO){
        return this.modelMapper.map(DTO, TipoMovimientoEntity.class);
    }
}
