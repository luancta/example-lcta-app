package br.com.ibner.projetoweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ibner.projetoweb.model.Responsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
	
	@Query("select responsavel from Responsavel responsavel order by responsavel.nome")
	public List<Responsavel> buscarTodosOrdenado();
	

}
