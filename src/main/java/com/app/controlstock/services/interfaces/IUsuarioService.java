package com.app.controlstock.services.interfaces;

import com.app.controlstock.dtos.request.ReqUsuarioDTO;
import com.app.controlstock.dtos.request.update.ReqPutProductoDTO;
import com.app.controlstock.dtos.request.update.ReqPutUsuarioDTO;
import com.app.controlstock.dtos.response.ResUsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUsuarioService {
    ResUsuarioDTO save(ReqUsuarioDTO reqUsuarioDTO);
    List<ResUsuarioDTO> getAll();
    List<ResUsuarioDTO> findByName(String name);
    ResUsuarioDTO findById(Long id);
    void deleteById(Long id);
    ResUsuarioDTO update(ReqPutUsuarioDTO reqPutUsuarioDTO);
}
