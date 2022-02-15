package com.challenge.bycoders.factory.impl;

import com.challenge.bycoders.entity.Proprietario;
import com.challenge.bycoders.entity.TipoTransacao;
import com.challenge.bycoders.entity.Transacao;
import com.challenge.bycoders.entity.TransacaoLoja;
import com.challenge.bycoders.factory.IParseStringToFile;
import com.challenge.bycoders.util.FileUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransacaoFactoryImpl implements IParseStringToFile {

    @Override
    public Set<TransacaoLoja> getProprietarioLoja(MultipartFile arquivo, List<Proprietario> proprietarios) throws IOException {

        Set<TransacaoLoja> lojas = new HashSet<>();

        for(String linha : toString(arquivo)) {

            TransacaoLoja store = new TransacaoLoja(FileUtil.getLojaTransacao(linha));
            store.setProprietario(proprietarios.stream()
                    .filter(x -> x.getNome().equals(FileUtil.getProprietarioTransacao(linha)))
                    .findFirst().orElse(null));

            lojas.add(store);
        }
        return lojas;
    }

    @Override
    public List<Transacao> getTransacoes(MultipartFile file,
                                           List<TransacaoLoja> lojas,
                                           List<TipoTransacao> tipos) throws Exception {
        return extrairDadosTransacao(toString(file), lojas, tipos);
    }

    public Set<Proprietario> getProprietarios(MultipartFile file) throws IOException {
        return extrairDadosProprietarios(toString(file));
    }

    private List<Transacao> extrairDadosTransacao(String[] records,
                                                  List<TransacaoLoja> lojas,
                                                  List<TipoTransacao> tipos) throws ParseException {

        List<Transacao> transacoes = new ArrayList<>();

        for(String item : records) {
            Transacao transaction = new Transacao();
            transaction.setCpf(FileUtil.getCPFTransacao(item));
            transaction.setHora(FileUtil.getHoraTransacao(item));
            transaction.setDataTransacao(FileUtil.getDataTransacao(item));
            transaction.setValue(FileUtil.getValorTransacao(item).divide(BigDecimal.valueOf(100)));
            transaction.setCartao(FileUtil.getCartaoTransacao(item));

            transaction.setTransacaoLoja(lojas.stream()
                    .filter(x -> x.getNomeLoja().equals(FileUtil.getLojaTransacao(item)))
                    .findFirst().orElse(null)
            );

            transaction.setTipoTransacao(tipos.stream()
                    .filter(x -> x.getId().equals(FileUtil.getTipoTransacao(item)))
                    .findFirst().orElse(null)
            );

            transacoes.add(transaction);
        }

        return transacoes;
    }

    public Set<Proprietario> extrairDadosProprietarios(String[] dados) {
        Set<Proprietario> proprietarios = new HashSet<>();
        for(String transacao : dados) {
            proprietarios.add(new Proprietario(FileUtil.getProprietarioTransacao(transacao)));
        }
        return proprietarios;
    }

    public Set<TransacaoLoja> extrairDadosLoja(String[] dados) {
        Set<TransacaoLoja> transacoes = new HashSet<>();
        for(String transacao : dados) {
            transacoes.add(new TransacaoLoja(FileUtil.getLojaTransacao(transacao)));
        }
        return transacoes;
    }
}
