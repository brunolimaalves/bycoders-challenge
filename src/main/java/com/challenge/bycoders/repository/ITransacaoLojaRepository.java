package com.challenge.bycoders.repository;

import com.challenge.bycoders.entity.TransacaoLoja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransacaoLojaRepository extends JpaRepository<TransacaoLoja, Long> {
}
