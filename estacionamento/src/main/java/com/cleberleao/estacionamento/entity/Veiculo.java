package com.cleberleao.estacionamento.entity;

import com.cleberleao.estacionamento.dto.RequestVeiculoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

    @Id
    private int id;

    private String placa;

    private String modelo;

    private String cor;

    private LocalDate dataCriacao;

    private LocalDate dataUpdate;

    public Veiculo(RequestVeiculoDTO dto) {
        this.modelo = dto.getModelo();
        this.cor = dto.getCor();
        this.placa = dto.getPlaca();
        this.dataCriacao = LocalDate.now();
    }
}
