package br.com.ibner.projetoweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.primefaces.component.tabview.TabView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ibner.projetoweb.model.Prioridade;
import br.com.ibner.projetoweb.model.Responsavel;
import br.com.ibner.projetoweb.model.Tarefa;
import br.com.ibner.projetoweb.repository.PrioridadeRepository;
import br.com.ibner.projetoweb.repository.ResponsavelRepository;
import br.com.ibner.projetoweb.repository.TarefaRepository;


@SuppressWarnings("deprecation")
@Named
@ViewScoped
public class TarefaController {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private ResponsavelRepository responsavelRepository;
	
	@Autowired
	private PrioridadeRepository prioridadeRepository;
	
	TabView tabView;
	
	private Tarefa tarefa = new Tarefa();
	
	private Responsavel responsavelSelecionado = new Responsavel();
	
	private Prioridade prioridadeSelecionada = new Prioridade();
	
	private List<SelectItem> responsaveisCombo;
	
	private List<SelectItem> prioridadesCombo;
	
	public List<Tarefa> getListaCompleta(){
		return tarefaRepository.buscarTodosOrdenado();
	}
	
	public String selecionar(Tarefa tarefa){
		this.tarefa = tarefa;
		setResponsavelSelecionado(tarefa.getResponsavel());
		setPrioridadeSelecionada(tarefa.getPrioridade());
		return "";
	}
	
	public void deletar(Tarefa tarefa){
		tarefaRepository.deleteById(tarefa.getId());
	}
	
	@RequestMapping("/")
	public void salvar() {
		tarefa.setResponsavel(responsavelSelecionado);
		tarefa.setPrioridade(prioridadeSelecionada);
		tarefaRepository.save(tarefa);
		tarefa = new Tarefa();
		responsavelSelecionado = new Responsavel();
		prioridadeSelecionada = new Prioridade();
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public TarefaRepository getTarefaRepository() {
		return tarefaRepository;
	}

	public void setTarefaRepository(TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}

	public TabView getTabView() {
		return tabView;
	}

	public void setTabView(TabView tabView) {
		this.tabView = tabView;
	}

	public ResponsavelRepository getResponsavelRepository() {
		return responsavelRepository;
	}

	public void setResponsavelRepository(ResponsavelRepository responsavelRepository) {
		this.responsavelRepository = responsavelRepository;
	}

	public PrioridadeRepository getPrioridadeRepository() {
		return prioridadeRepository;
	}

	public void setPrioridadeRepository(PrioridadeRepository prioridadeRepository) {
		this.prioridadeRepository = prioridadeRepository;
	}

	public List<SelectItem> getResponsaveisCombo() {
		if(responsaveisCombo == null || responsaveisCombo.isEmpty()) {
			responsaveisCombo = new ArrayList<SelectItem>();
			List<Responsavel> responsaveis = responsavelRepository.buscarTodosOrdenado();
			for(Responsavel responsavel:responsaveis) {
				responsaveisCombo.add(new SelectItem(responsavel.getId(),responsavel.getNome()));
			}
		}
		return responsaveisCombo;
	}
	
	public List<Responsavel> getResponsaveis() {
		return responsavelRepository.buscarTodosOrdenado();
	}
	
	public List<Prioridade> getPrioridades() {
		return prioridadeRepository.buscarTodosOrdenado();
	}
	
	public List<SelectItem> getPrioridadesCombo() {
		if(prioridadesCombo == null || prioridadesCombo.isEmpty()) {
			prioridadesCombo = new ArrayList<SelectItem>();
			List<Prioridade> prioridades = getPrioridades();
			for(Prioridade prioridade: prioridades) {
				prioridadesCombo.add(new SelectItem(prioridade.getId(),prioridade.getNome()));
			}
		}
		return prioridadesCombo;
	}
	
	public void setResponsaveisCombo(List<SelectItem> responsaveisCombo) {
		this.responsaveisCombo = responsaveisCombo;
	}

	public Responsavel getResponsavelSelecionado() {
		return responsavelSelecionado;
	}

	public void setResponsavelSelecionado(Responsavel responsavelSelecionado) {
		this.responsavelSelecionado = responsavelSelecionado;
	}

	public Prioridade getPrioridadeSelecionada() {
		return prioridadeSelecionada;
	}

	public void setPrioridadeSelecionada(Prioridade prioridadeSelecionada) {
		this.prioridadeSelecionada = prioridadeSelecionada;
	}
	
}
