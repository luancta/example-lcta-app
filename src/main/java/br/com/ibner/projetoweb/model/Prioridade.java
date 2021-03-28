package br.com.ibner.projetoweb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prioridade")
public class Prioridade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	
	public Prioridade() {
		
	}
	
	public Prioridade(String nome) {
		this.nome = nome;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
    @Override
    public boolean equals(Object outro) {
        return (outro instanceof Prioridade)
            ? id == ((Prioridade) outro).getId()
            : (outro == this);
    }

    @Override
    public int hashCode() {
            return (this.getClass().hashCode() + id + nome).hashCode();
    }

    @Override
    public String toString() {
        return String.format(id + " - " + nome);
    }
	
}
