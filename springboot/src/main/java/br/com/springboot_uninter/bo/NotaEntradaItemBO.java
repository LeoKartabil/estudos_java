package br.com.springboot_uninter.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot_uninter.dao.CRUD;
import br.com.springboot_uninter.dao.NotaEntradaItemDAO;
import br.com.springboot_uninter.model.NotaEntradaItem;

@Service
public class NotaEntradaItemBO implements CRUD<NotaEntradaItem, Long> {

	@Autowired
	private NotaEntradaItemDAO dao;
	
	@Override
	public NotaEntradaItem pesquisaPeloId(Long id) {
		return dao.pesquisaPeloId(id);
	}

	@Override
	public List<NotaEntradaItem> listaTodos() {
		return dao.listaTodos();
	}

	@Override
	public void insere(NotaEntradaItem notaEntradaItem) {
		dao.insere(notaEntradaItem);
	}

	@Override
	public void atualiza(NotaEntradaItem notaEntradaItem) {
		dao.atualiza(notaEntradaItem);
	}

	@Override
	public void remove(NotaEntradaItem notaEntradaItem) {
		dao.remove(notaEntradaItem);
	}

	@Override
	public List<NotaEntradaItem> lista() {
		return dao.lista();
	}
}
