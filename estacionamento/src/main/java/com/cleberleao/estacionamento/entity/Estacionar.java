package com.cleberleao.estacionamento.entity;

import com.cleberleao.estacionamento.dto.RequestEstacionarDTO;
import com.cleberleao.estacionamento.dto.ResponseEstacionarDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estacionar {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    private Date entrada;

    private Date saida;

    private LocalDate dataCriacao;

    private LocalDate dataUpdate;

    public Estacionar(RequestEstacionarDTO dto) {
        this.veiculo = dto.getVeiculo();
        this.dataCriacao = LocalDate.now();
        this.entrada = dto.getEntrada();
        this.saida = dto.getSaida();
    }
}
