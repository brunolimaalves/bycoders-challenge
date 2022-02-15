package com.challenge.bycoders.repository;

import com.challenge.bycoders.entity.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProprietarioRepository extends JpaRepository<Proprietario, Long> {
}
