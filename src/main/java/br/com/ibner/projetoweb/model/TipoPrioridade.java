package br.com.ibner.projetoweb.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public enum TipoPrioridade {

	INVALIDO,
	BAIXA,
	MEDIA,
	ALTA;
	
	public String getDescricao() {
		switch(this) {
			case BAIXA:	return "Baixa";
			case MEDIA:	return "Média";
			case ALTA:	return "Alta";
			default:	return "";
		}
	}
	
	public List<TipoPrioridade> getTiposPrioridade() {
		List<TipoPrioridade> prioridades = new ArrayList<TipoPrioridade>();
		prioridades.add(BAIXA);
		prioridades.add(MEDIA);
		prioridades.add(ALTA);
		return prioridades;
	}
	
}
