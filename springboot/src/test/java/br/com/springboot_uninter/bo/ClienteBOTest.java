package br.com.springboot_uninter.bo;

import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.springboot_uninter.model.Cliente;
import br.com.springboot_uninter.model.Sexo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
final public class ClienteBOTest {

	@Autowired
	private ClienteBO bo;
	
	@Test
	@Order(1)
	public void insere() {
		Cliente cliente = new Cliente();
		cliente.setNome("Leonardo Kartabil");
		cliente.setCpf("018.414.640-23");
		cliente.setDataDeNascimento(LocalDate.of(1977, 07, 07));
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setCelular("(54)98143-4343");
		cliente.setTelefone("(54)3313-7777");
		cliente.setAtivo(true);
		assertNotNull(cliente);
		bo.insere(cliente);
	}
	
	@Test
	@Order(2)
	public void pesquisaPeloId() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		assertNotNull(cliente);
		System.out.println(cliente);
	}
	
	@Test
	@Order(3)
	public void lista() {
		List<Cliente> clientes = bo.lista();
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
	
	@Test
	@Order(4)
	public void listaTodos() {
		List<Cliente> clientes = bo.listaTodos();
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
	
	@Test
	@Order(5)
	public void atualiza() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		cliente.setNome("Novo Nome");
		bo.atualiza(cliente);
	}
	
	@Test
	@Order(6)
	public void inativa() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		bo.inativa(cliente);
	}
	
	@Test
	@Order(7)
	public void ativa() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		bo.ativa(cliente);
	}
	
//	@Test
//	@Order(8)
//	public void remove() {
//		Cliente cliente = bo.pesquisaPeloId(1L);
//		bo.remove(cliente);
//	}
	
	
}