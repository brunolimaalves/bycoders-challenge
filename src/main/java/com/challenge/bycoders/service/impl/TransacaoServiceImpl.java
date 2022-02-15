package com.challenge.bycoders.service.impl;

import com.challenge.bycoders.entity.Proprietario;
import com.challenge.bycoders.entity.TipoTransacao;
import com.challenge.bycoders.entity.Transacao;
import com.challenge.bycoders.entity.TransacaoLoja;
import com.challenge.bycoders.factory.IParseStringToFile;
import com.challenge.bycoders.repository.ITransacaoRepository;
import com.challenge.bycoders.service.IProprietarioService;
import com.challenge.bycoders.service.ITipoTransacaoService;
import com.challenge.bycoders.service.ITransacaoLojaService;
import com.challenge.bycoders.service.ITransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TransacaoServiceImpl implements ITransacaoService {

    @Autowired
    private ITransacaoRepository transacaoRepositoryy;

    @Autowired
    private ITransacaoLojaService lojaService;

    @Autowired
    private ITipoTransacaoService tipoService;

    @Autowired
    private IProprietarioService proprietarioService;

    @Override
    public void salvarTransacoes(IParseStringToFile parseStringToFile, MultipartFile arquivo) throws Exception {
        List<Proprietario> proprietarios = salvarTodosProprietarios(parseStringToFile.getProprietarios(arquivo));
        List<TransacaoLoja> lojas = salvarTodasLojas(parseStringToFile.getProprietarioLoja(arquivo, proprietarios));
        transacaoRepositoryy.saveAll(parseStringToFile.getTransacoes(arquivo, lojas, buscarTodosTiposTransacao()));
    }

    private List<Proprietario> salvarTodosProprietarios(Set<Proprietario> owners) {
        List<Proprietario> proprietarios = proprietarioService.buscarTodos();
        for(Proprietario proprietario : proprietarios) {
            if(!proprietarios.contains(proprietario)) {
                proprietarioService.salvar(proprietario);
            }
        }
        return proprietarioService.buscarTodos();
    }

    private List<TransacaoLoja> salvarTodasLojas(Set<TransacaoLoja> lojas) {
        List<TransacaoLoja> lojasDb = lojaService.buscarTodos();

        for(TransacaoLoja loja : lojas) {
            if(!lojasDb.contains(loja)) {
                lojaService.salvar(loja);
            }
        }
        return lojaService.buscarTodos();
    }

    @Override
    public Optional<Transacao> buscarTransacaoPorId(Long id) {
        return transacaoRepositoryy.findById(id);
    }

    @Override
    public List<Transacao> buscarTransacoes() {
        return transacaoRepositoryy.findAll();
    }

    private List<TipoTransacao> buscarTodosTiposTransacao() {
        return tipoService.buscarTodos();
    }

}
