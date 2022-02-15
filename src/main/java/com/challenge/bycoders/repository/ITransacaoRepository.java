package com.challenge.bycoders.repository;

import com.challenge.bycoders.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransacaoRepository extends JpaRepository<Transacao, Long> {

}
