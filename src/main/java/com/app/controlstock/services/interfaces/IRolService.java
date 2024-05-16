package com.app.controlstock.services.interfaces;

import com.app.controlstock.dtos.request.ReqRolDTO;
import com.app.controlstock.dtos.response.ResRolDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRolService {

    ResRolDTO save(ReqRolDTO reqRolDTO);
    List<ResRolDTO> getAll();
    ResRolDTO findById(Long id);
}
