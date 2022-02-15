package com.challenge.bycoders.service.impl;

import com.challenge.bycoders.entity.TipoTransacao;
import com.challenge.bycoders.repository.ITipoTransacaoRepository;
import com.challenge.bycoders.service.ITipoTransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoTransacaoServiceImpl implements ITipoTransacaoService {

    private ITipoTransacaoRepository tipoRepository;

    public List<TipoTransacao> buscarTodos() {
        return tipoRepository.findAll();
    }

    @Autowired
    public void setTypeRepository(ITipoTransacaoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }
}
