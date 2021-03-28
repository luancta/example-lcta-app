package br.com.ibner.projetoweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ibner.projetoweb.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("select p from Produto p where p.descricao=:descricao")
	public Produto buscarPorDescricao(@Param("descricao")String descricao);
	
	
	@Query("select p from Produto p order by p.nome, p.descricao")
	public List<Produto> buscarTodosOrdenado();
}
