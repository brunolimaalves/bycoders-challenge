package com.challenge.bycoders.service.impl;

import com.challenge.bycoders.entity.Proprietario;
import com.challenge.bycoders.repository.IProprietarioRepository;
import com.challenge.bycoders.service.IProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProprietarioServiceImpl implements IProprietarioService {

    @Autowired
    private IProprietarioRepository proprietarioRepository;

    public List<Proprietario> salvarTodos (Set<Proprietario> proprietarios){
        return proprietarioRepository.saveAll(proprietarios);
    }

    @Override
    public List<Proprietario> buscarTodos() {
        return proprietarioRepository.findAll();
    }

    @Override
    public void salvar(Proprietario proprietario) {
        proprietarioRepository.save(proprietario);
    }

    public List<Proprietario> buscarTodosProprietarios (){
        return proprietarioRepository.findAll();
    }



}
