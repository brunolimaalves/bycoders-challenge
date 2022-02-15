package com.challenge.bycoders.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_TRANSACAO_LOJA")
public class TransacaoLoja implements Serializable {

    public TransacaoLoja(){ }

    public TransacaoLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    private static final Long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME_LOJA")
    private String nomeLoja;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_ID_PROPRIETARIO", referencedColumnName = "ID")
    private Proprietario proprietario;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "transacaoLoja")
    private List<Transacao> transacoes = new ArrayList<>();

    public BigDecimal getTotal() {
        return transacoes.stream().map(Transacao::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransacaoLoja that = (TransacaoLoja) o;
        return Objects.equals(nomeLoja, that.nomeLoja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeLoja);
    }

    public Long getValoresEntrada() {
        return transacoes.stream()
                .map(Transacao::getTipoTransacao)
                .map(TipoTransacao::getSinal)
                .filter("+"::equals).count();
    }

    public Long getValoresSaida() {
        return transacoes.stream()
                .map(Transacao::getTipoTransacao)
                .map(TipoTransacao::getSinal)
                .filter("-"::equals).count();
    }

}
