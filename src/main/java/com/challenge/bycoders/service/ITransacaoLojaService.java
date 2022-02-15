package com.challenge.bycoders.service;

import com.challenge.bycoders.entity.TransacaoLoja;

import java.util.List;
import java.util.Set;

public interface ITransacaoLojaService {
    List<TransacaoLoja> salvarTodos(Set<TransacaoLoja> lojas);

    List<TransacaoLoja> buscarTodos();

    void salvar(TransacaoLoja store);
}
