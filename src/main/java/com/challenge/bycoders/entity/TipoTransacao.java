package com.challenge.bycoders.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_TIPO_TRANSACAO")
public class TipoTransacao implements Serializable {

    public TipoTransacao() {}

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "SINAL")
    private String sinal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSinal() {
        return sinal;
    }

    public void setSinal(String sinal) {
        this.sinal = sinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoTransacao that = (TipoTransacao) o;
        return id.equals(that.id) && Objects.equals(nome, that.nome) && Objects.equals(tipo, that.tipo)
                && Objects.equals(sinal, that.sinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, tipo, sinal);
    }
}
