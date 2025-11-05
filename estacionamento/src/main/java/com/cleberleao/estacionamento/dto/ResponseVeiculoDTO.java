package com.cleberleao.estacionamento.dto;

import com.cleberleao.estacionamento.entity.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVeiculoDTO {

    private int id;

    private String placa;

    private String modelo;

    private String cor;

    public ResponseVeiculoDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.modelo = veiculo.getModelo();
        this.cor = veiculo.getCor();
        this.placa = veiculo.getPlaca();
    }
}
