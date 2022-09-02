package br.com.springboot_uninter.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.springboot_uninter.model.Categoria;

@Transactional
public class CategoriaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insere(Categoria categoria) {
		entityManager.persist(categoria);
	}
	
	

}
