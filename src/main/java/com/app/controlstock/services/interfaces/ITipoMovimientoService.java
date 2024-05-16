package com.app.controlstock.services.interfaces;

import com.app.controlstock.dtos.request.ReqTipoMovimientoDTO;
import com.app.controlstock.dtos.response.ResTipoMovimientoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITipoMovimientoService {
    ResTipoMovimientoDTO save(ReqTipoMovimientoDTO reqTipoMovimientoDTO);
    List<ResTipoMovimientoDTO> getAll();
    ResTipoMovimientoDTO findById(Long id);
}
