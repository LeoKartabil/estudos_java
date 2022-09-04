package br.com.springboot_uninter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.springboot_uninter.model.Fornecedor;
import br.com.springboot_uninter.model.NotaEntrada;

@Repository
@Transactional
public class NotaEntradaDAO implements CRUD<NotaEntrada, Long>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public NotaEntrada pesquisaPeloId(Long id) {
		return em.find(NotaEntrada.class, id);
	}

	@Override
	public List<NotaEntrada> listaTodos() {
		Query query = em.createQuery("SELECT ne FROM NotaEntrada ne");
		return (List<NotaEntrada>) query.getResultList();
	}

	@Override
	public List<NotaEntrada> lista() {
		Query query = em.createQuery("SELECT ne FROM NotaEntrada ne");
		return (List<NotaEntrada>) query.getResultList();
	}

	@Override
	public void insere(NotaEntrada notaEntrada) {
		em.persist(notaEntrada);
		
	}

	@Override
	public void atualiza(NotaEntrada notaEntrada) {
		em.merge(notaEntrada);
		
	}

	@Override
	public void remove(NotaEntrada notaEntrada) {
		em.remove(em.contains(notaEntrada) ? notaEntrada : em.merge(notaEntrada));
		
	}
}
