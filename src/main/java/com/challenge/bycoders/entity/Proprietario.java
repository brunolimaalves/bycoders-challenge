package com.challenge.bycoders.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_PROPRIETARIO")
public class Proprietario implements Serializable {

    private static final Long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proprietario proprietario = (Proprietario) o;
        return nome.equals(proprietario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public Proprietario(String nome) {
        this.nome = nome;
    }

    public Proprietario() {}

}
