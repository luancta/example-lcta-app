package br.com.ibner.projetoweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ibner.projetoweb.model.Prioridade;

@Repository
public interface PrioridadeRepository extends JpaRepository<Prioridade, Long> {
	
	@Query("select prioridade from Prioridade prioridade order by prioridade.id")
	public List<Prioridade> buscarTodosOrdenado();
	

}
