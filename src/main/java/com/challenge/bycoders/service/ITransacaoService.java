package com.challenge.bycoders.service;


import com.challenge.bycoders.entity.Transacao;
import com.challenge.bycoders.factory.IParseStringToFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ITransacaoService {
    void salvarTransacoes(IParseStringToFile parseStringToFile, MultipartFile arquivo) throws Exception;

    List<Transacao> buscarTransacoes();

    Optional<Transacao> buscarTransacaoPorId(Long id);
}
