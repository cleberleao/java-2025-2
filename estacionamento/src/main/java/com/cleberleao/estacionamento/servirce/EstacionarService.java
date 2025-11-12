package com.cleberleao.estacionamento.servirce;

import com.cleberleao.estacionamento.dto.RequestEstacionarDTO;
import com.cleberleao.estacionamento.dto.ResponseEstacionarDTO;
import com.cleberleao.estacionamento.entity.Estacionar;
import com.cleberleao.estacionamento.repository.EstacionarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstacionarService {

    @Autowired
    EstacionarRepository estacionarRepository;

    public ResponseEstacionarDTO cadastrar(RequestEstacionarDTO dto) {
        Estacionar save = estacionarRepository.save(new Estacionar(dto));
        return new ResponseEstacionarDTO(save);
    }

    public List<ResponseEstacionarDTO> buscarVagasLivres(){
        return new ArrayList<>();
    }
}
