package com.cleberleao.estacionamento.repository;

import com.cleberleao.estacionamento.entity.Estacionar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionarRepository extends JpaRepository<Estacionar, Long> {
}
