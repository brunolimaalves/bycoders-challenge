package com.challenge.bycoders.service.impl;

import com.challenge.bycoders.entity.TransacaoLoja;
import com.challenge.bycoders.repository.ITransacaoLojaRepository;
import com.challenge.bycoders.service.ITransacaoLojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TransacaoLojaServiceImpl implements ITransacaoLojaService {

    @Autowired
    private ITransacaoLojaRepository lojaRepository;

    @Override
    public List<TransacaoLoja> salvarTodos(Set<TransacaoLoja> lojas) {
        return lojaRepository.saveAll(lojas);
    }

    @Override
    public List<TransacaoLoja> buscarTodos() {
        return lojaRepository.findAll();
    }

    @Override
    public void salvar(TransacaoLoja loja) {
        lojaRepository.save(loja);
    }

}
