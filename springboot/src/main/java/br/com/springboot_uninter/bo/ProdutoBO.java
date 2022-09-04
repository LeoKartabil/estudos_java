package br.com.springboot_uninter.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot_uninter.dao.CRUD;
import br.com.springboot_uninter.dao.ProdutoDAO;
import br.com.springboot_uninter.model.Produto;

@Service
public class ProdutoBO implements CRUD<Produto, Long>{
	
	@Autowired
	private ProdutoDAO dao;
	
	@Override
	public Produto pesquisaPeloId(Long id) {
		return dao.pesquisaPeloId(id);
	}

	@Override
	public List<Produto> listaTodos() {
		return dao.listaTodos();
	}

	@Override
	public List<Produto> lista() {
		return dao.lista();
	}

	@Override
	public void insere(Produto produto) {
		dao.insere(produto);
	}

	@Override
	public void atualiza(Produto produto) {
		dao.atualiza(produto);
	}

	@Override
	public void remove(Produto produto) {
		dao.remove(produto);
	}
	
	public void ativa(Produto produto) {
		produto.setAtivo(true);
		dao.atualiza(produto);
	}
	
	public void inativa(Produto produto) {
		produto.setAtivo(false);
		dao.atualiza(produto);
	}
}
