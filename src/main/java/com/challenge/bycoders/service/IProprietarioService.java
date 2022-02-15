package com.challenge.bycoders.service;

import com.challenge.bycoders.entity.Proprietario;

import java.util.List;
import java.util.Set;

public interface IProprietarioService {
    List<Proprietario> salvarTodos(Set<Proprietario> owners);

    List<Proprietario> buscarTodos();

    void salvar(Proprietario owner);
}
