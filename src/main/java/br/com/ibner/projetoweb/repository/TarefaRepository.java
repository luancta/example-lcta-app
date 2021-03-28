package br.com.ibner.projetoweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ibner.projetoweb.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
	@Query("select tarefa from Tarefa tarefa where tarefa.titulo=tilulo")
	public Tarefa buscarPorTitulo(@Param("titulo")String titulo);
	
	@Query("select tarefa from Tarefa tarefa where tarefa.descricao=:descricao")
	public Tarefa buscarPorDescricao(@Param("descricao")String descricao);
	
	
	@Query("select tarefa from Tarefa tarefa order by tarefa.titulo, tarefa.descricao")
	public List<Tarefa> buscarTodosOrdenado();
	

}
