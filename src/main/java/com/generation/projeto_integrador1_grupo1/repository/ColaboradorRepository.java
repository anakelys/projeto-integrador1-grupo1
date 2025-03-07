package com.generation.projeto_integrador1_grupo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.projeto_integrador1_grupo1.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
	
	//metodo para buscar pelo nome
	public List <Colaborador> findAllByNomeContainingIgnoreCase(@Param("nome")String nome);
	
}
