package br.com.springboot.bo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.springboot.model.Cliente;
import br.com.springboot.model.Sexo;

public class ClienteBOTest {
	
	@Autowired
	private ClienteBO bo;
	
	public void insere() {
		Cliente cliente = new Cliente();
		cliente.setNome("Leonardo Kartabil");
		cliente.setCpf("02143554779");
		cliente.setDataDeNascimento(LocalDate.of(1999, 2, 9));
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setTelefone("3313-5543");
		cliente.setCelular("981443223");
		bo.insere(cliente);
	}
	
	public void pesquisaPeloId() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		System.out.println(cliente);
	}
	
	public void atualiza() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		bo.atualiza(cliente);
	}
	
	public void remove() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		bo.remove(cliente);
	}
	
	public void inativa() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		bo.inativa(cliente);
	}
	
	public void ativa() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		bo.ativa(cliente);
	}
	
	
	
	
}
