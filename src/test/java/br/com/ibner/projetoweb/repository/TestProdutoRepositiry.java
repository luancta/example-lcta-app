package br.com.ibner.projetoweb.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ibner.projetoweb.model.Produto;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestProdutoRepositiry {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Test
	public void testSalvar(){
		
		Produto p = new Produto("Refri","Refrigerante",10);
		Produto pSalvo = produtoRepository.save(p);
		Assert.assertNotNull(pSalvo.getId());
		
	}
	
}
