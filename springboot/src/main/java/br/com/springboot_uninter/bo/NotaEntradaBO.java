package br.com.springboot_uninter.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot_uninter.dao.CRUD;
import br.com.springboot_uninter.dao.NotaEntradaDAO;
import br.com.springboot_uninter.model.NotaEntrada;

@Service
public class NotaEntradaBO implements CRUD<NotaEntrada, Long>{
	
	@Autowired
	private NotaEntradaDAO dao;

	@Override
	public NotaEntrada pesquisaPeloId(Long id) {
		return dao.pesquisaPeloId(id);
	}

	@Override
	public List<NotaEntrada> listaTodos() {
		return dao.listaTodos();
	}

	@Override
	public List<NotaEntrada> lista() {
		return dao.lista();
	}

	@Override
	public void insere(NotaEntrada notaEntrada) {
		dao.insere(notaEntrada);
	}

	@Override
	public void atualiza(NotaEntrada notaEntrada) {
		dao.atualiza(notaEntrada);
	}

	@Override
	public void remove(NotaEntrada notaEntrada) {
		dao.remove(notaEntrada);
	}
}
