package br.com.ibner.projetoweb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tarefa")
public class Tarefa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	private String titulo;
	private String descricao;
	private Date deadline;
	@ManyToOne
	@JoinColumn(name = "responsavel_id")
	private Responsavel responsavel;
	@ManyToOne
	@JoinColumn(name = "prioridade_id")
	private Prioridade prioridade;
	
	public Tarefa() {
		responsavel = new Responsavel();
		prioridade = new Prioridade();
	}
	
	public Tarefa(String titulo, String descricao, Date deadline, Responsavel responsavel, Prioridade prioridade) {
		this.titulo=titulo;
		this.descricao=descricao;
		this.deadline=deadline;
		this.responsavel=responsavel;
		this.prioridade=prioridade;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

    @Override
    public boolean equals(Object outro) {
        return (outro instanceof Responsavel)
            ? id == ((Responsavel) outro).getId()
            : (outro == this);
    }

    @Override
    public int hashCode() {
            return (this.getClass().hashCode() + id + titulo).hashCode();
    }

    @Override
    public String toString() {
        return String.format(id + " - " + titulo);
    }
	

}
