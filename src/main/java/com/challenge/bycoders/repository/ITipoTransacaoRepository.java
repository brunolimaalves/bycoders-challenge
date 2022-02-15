package com.challenge.bycoders.repository;

import com.challenge.bycoders.entity.TipoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoTransacaoRepository extends JpaRepository<TipoTransacao, Long> {
}
