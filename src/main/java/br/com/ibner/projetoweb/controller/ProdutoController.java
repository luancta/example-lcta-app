package br.com.ibner.projetoweb.controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.component.tabview.TabView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ibner.projetoweb.model.Produto;
import br.com.ibner.projetoweb.repository.ProdutoRepository;


@Named
@ViewScoped
@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	TabView tabView;
	
	private Produto produto = new Produto();
	
	public List<Produto> getListaCompleta(){
		return produtoRepository.buscarTodosOrdenado();
	}
	
	public String selecionar(Produto produto){
		this.produto = produto;
		return "";
	}
	
	public void deletar(Produto produto){
		produtoRepository.deleteById(produto.getId());
	}
	
	@RequestMapping("/produto")
	public void salvar() {
		produtoRepository.save(produto);
		produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoRepository getProdutoRepository() {
		return produtoRepository;
	}

	public void setProdutoRepository(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public TabView getTabView() {
		return tabView;
	}

	public void setTabView(TabView tabView) {
		this.tabView = tabView;
	}
	
}
