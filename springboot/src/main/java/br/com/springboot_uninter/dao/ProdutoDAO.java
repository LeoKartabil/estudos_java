package br.com.springboot_uninter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.springboot_uninter.model.Produto;

@Repository
@Transactional
public class ProdutoDAO implements CRUD<Produto, Long>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Produto pesquisaPeloId(Long id) {
		return em.find(Produto.class, id);
		
	}

	@Override
	public List<Produto> listaTodos() {
		Query query = em.createQuery("SELECT p FROM Produto p");
		return (List<Produto>) query.getResultList();
	}

	@Override
	public List<Produto> lista() {
		Query query = em.createQuery("SELECT p FROM Produto p");
		return (List<Produto>) query.getResultList();
	}

	@Override
	public void insere(Produto produto) {
		em.persist(produto);
		
	}

	@Override
	public void atualiza(Produto produto) {
		em.merge(produto);
		
	}

	@Override
	public void remove(Produto produto) {
		em.remove(em.contains(produto) ? produto : em.merge(produto));
	}

}
