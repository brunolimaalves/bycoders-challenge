package com.challenge.bycoders.controller;

import com.challenge.bycoders.entity.Transacao;
import com.challenge.bycoders.entity.TransacaoLoja;
import com.challenge.bycoders.service.ITransacaoLojaService;
import com.challenge.bycoders.service.ITransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cnab-api")
public class TransacaoController {

    @Autowired
    private ITransacaoService transacaoService;

    @Autowired
    private ITransacaoLojaService transacaoLojaService;

    @GetMapping("/transacoes")
    public ResponseEntity<List<Transacao>> buscarTodasTransacoes() {
        return ResponseEntity.ok().body(transacaoService.buscarTransacoes());
    }

    @GetMapping("/transacao/{id}")
    public ResponseEntity<Transacao> buscarTransacaoPorId(@PathVariable Long id) {
        Optional<Transacao> transacao = transacaoService.buscarTransacaoPorId(id);
        return transacao.map(item -> ResponseEntity.ok().body(item)).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/transacoeslojas")
    public ResponseEntity<List<TransacaoLoja>> buscarTransacoesPorLoja() {
        return ResponseEntity.ok().body(transacaoLojaService.buscarTodos());
    }
}
