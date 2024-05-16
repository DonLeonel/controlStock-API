package com.app.controlstock.services;

import com.app.controlstock.dtos.request.ReqUsuarioDTO;
import com.app.controlstock.dtos.request.update.ReqPutUsuarioDTO;
import com.app.controlstock.dtos.response.ResUsuarioDTO;
import com.app.controlstock.entities.CategoriaEntity;
import com.app.controlstock.entities.ProductoEntity;
import com.app.controlstock.entities.UsuarioEntity;
import com.app.controlstock.exceptions.NotFoundException;
import com.app.controlstock.respositories.UsuarioJpaRepository;
import com.app.controlstock.services.interfaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    private final UsuarioJpaRepository repository;
    private final ModelMapper modelMapper;
    private final ModelMapper mergerMapper;

    public UsuarioService(UsuarioJpaRepository repository, ModelMapper modelMapper, ModelMapper mergerMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.mergerMapper = mergerMapper;
    }

    @Override
    public ResUsuarioDTO save(ReqUsuarioDTO reqUsuarioDTO) {
        reqUsuarioDTO.setFechaCreacion(LocalDateTime.now());
        reqUsuarioDTO.setFechaActualizacion(LocalDateTime.now());
        reqUsuarioDTO.setBorrado(false);
        return mapToResDTO(repository.save(mapToEntity(reqUsuarioDTO)));
    }

    @Override
    public List<ResUsuarioDTO> getAll() {
        return repository.findAll().stream()
                .filter(u->u.getBorrado().equals(false))
                .map(this::mapToResDTO)
                .toList();
    }

    @Override
    public List<ResUsuarioDTO> findByName(String name) {
        return repository.findByNombre(name).stream()
                .filter(u->u.getBorrado().equals(false))
                .map(this::mapToResDTO)
                .toList();
    }

    @Override
    public ResUsuarioDTO findById(Long id) {
        UsuarioEntity Entity = repository.findById(id).orElseThrow(
                ()-> new NotFoundException("No se encontro el Usuario."));
        return mapToResDTO(Entity);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        UsuarioEntity entity = repository.getReferenceById(id);
        entity.setBorrado(true);
        repository.save(entity);
    }

    @Override
    public ResUsuarioDTO update(ReqPutUsuarioDTO reqPutUsuarioDTO) {
        UsuarioEntity Entity = repository.getReferenceById(reqPutUsuarioDTO.getId());
        Entity.setFechaActualizacion(LocalDateTime.now());
        mergerMapper.map(reqPutUsuarioDTO, Entity);
        return mapToResDTO(repository.save(Entity));
    }

    private ResUsuarioDTO mapToResDTO(UsuarioEntity entity){
        return this.modelMapper.map(entity, ResUsuarioDTO.class);
    }
    private UsuarioEntity mapToEntity(ReqUsuarioDTO DTO){
        return this.modelMapper.map(DTO, UsuarioEntity.class);
    }
}
