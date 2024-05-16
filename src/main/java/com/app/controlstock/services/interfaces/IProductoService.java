package com.app.controlstock.services.interfaces;

import com.app.controlstock.dtos.request.ReqProductoDTO;
import com.app.controlstock.dtos.request.ReqPutProductoDTO;
import com.app.controlstock.dtos.response.ResProductoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IProductoService {
    ResProductoDTO save(ReqProductoDTO requestProductoDTO);
    List<ResProductoDTO> getAll();
    List<ResProductoDTO> findByName(String name);
    ResProductoDTO findById(Long id);
    ResProductoDTO update(ReqPutProductoDTO reqPutProductoDTO);
    void deleteById(Long id);

}
