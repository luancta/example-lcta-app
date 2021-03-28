package br.com.ibner.projetoweb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	
	private String descricao;
	private String nome;
	private int quantidade;

	public Produto() {
		
	}
	
	public Produto(String descricao, String nome, int quantidade) {
		this.descricao=descricao;
		this.nome=nome;
		this.quantidade=quantidade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
