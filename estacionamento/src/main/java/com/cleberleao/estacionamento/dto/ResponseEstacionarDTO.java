package com.cleberleao.estacionamento.dto;

import com.cleberleao.estacionamento.entity.Estacionar;
import com.cleberleao.estacionamento.entity.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEstacionarDTO {

    private int id;

    private ResponseVeiculoDTO veiculo;

    private Date entrada;

    private Date saida;

    public ResponseEstacionarDTO(Estacionar estacionar) {
        this.id = estacionar.getId();
        this.veiculo = new ResponseVeiculoDTO(estacionar.getVeiculo());
        this.entrada = estacionar.getEntrada();
        this.saida = estacionar.getSaida();
    }


}
