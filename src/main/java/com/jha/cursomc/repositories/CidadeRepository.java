package com.jha.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jha.cursomc.domain.Cidade;

@Repository

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
