package com.cleberleao.estacionamento.controller;

import com.cleberleao.estacionamento.dto.RequestEstacionarDTO;
import com.cleberleao.estacionamento.dto.ResponseEstacionarDTO;
import com.cleberleao.estacionamento.servirce.EstacionarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estacionar")
@CrossOrigin("*")
public class EstacionarController {

    @Autowired
    EstacionarService estacionarService;

    @PostMapping
    public ResponseEntity<ResponseEstacionarDTO> cadastrar(@RequestBody RequestEstacionarDTO dto){
        ResponseEstacionarDTO responseEstacionarDTO = estacionarService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseEstacionarDTO);
    }
    
    @GetMapping("/vagas-livres")
    public ResponseEntity<List<ResponseEstacionarDTO>> vagasLivres(){
        List<ResponseEstacionarDTO> dto = estacionarService.buscarVagasLivres();
        return ResponseEntity.ok(dto);
    }
}
