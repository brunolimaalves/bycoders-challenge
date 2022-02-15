package com.challenge.bycoders.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB_TRANSACAO")
public class Transacao implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "CARTAO")
    private String cartao;

    @Column(name = "DT_TRANSACAO")
    private Date dataTransacao;

    @Column(name = "HORA")
    private Date hora;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_ID_TRANSACAO", referencedColumnName = "ID")
    private TransacaoLoja transacaoLoja;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_ID_TIPO_TRANSACAO", referencedColumnName = "ID")
    private TipoTransacao tipoTransacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public BigDecimal getValor() {
        if(tipoTransacao != null && tipoTransacao.getSinal().equals("-")) {
            valor = valor.negate();
        }
        return valor;
    }

    public void setValue(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String numero) {
        this.cartao = cartao;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public TransacaoLoja getTransacaoLoja() {
        return transacaoLoja;
    }

    public void setTransacaoLoja(TransacaoLoja transacaoLoja) {
        this.transacaoLoja = transacaoLoja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao that = (Transacao) o;
        return Objects.equals(dataTransacao, that.dataTransacao) && Objects.equals(cpf, that.cpf)
                && Objects.equals(hora, that.hora) && Objects.equals(tipoTransacao, that.tipoTransacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataTransacao, cpf, hora, tipoTransacao);
    }
}
