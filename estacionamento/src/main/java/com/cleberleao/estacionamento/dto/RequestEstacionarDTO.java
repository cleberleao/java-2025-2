package com.cleberleao.estacionamento.dto;

import com.cleberleao.estacionamento.entity.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestEstacionarDTO {

    private Veiculo veiculo;

    private Date entrada;

    private Date saida;
}
