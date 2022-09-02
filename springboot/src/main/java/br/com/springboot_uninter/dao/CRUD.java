package br.com.springboot_uninter.dao;

import java.util.List;

public interface CRUD<T, ID> {
	T pesquisaPeloId(ID id);
	List<T> listaTodos();
	List<T> lista();
	void insere(T t);
	void atualiza(T t);
	void remove(T t);
}
