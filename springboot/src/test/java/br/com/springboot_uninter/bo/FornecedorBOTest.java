package br.com.springboot_uninter.bo;

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

import br.com.springboot_uninter.model.Fornecedor;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
final public class FornecedorBOTest {

	@Autowired
	private FornecedorBO bo;
	
	@Test
	@Order(1)
	public void insere() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNomeFantasia("Sweet Ceci");
		fornecedor.setRazaoSocial("Cecilia Doces e Cia Ldta");
		fornecedor.setCnpj("96.312.866/0001-07");
		fornecedor.setCelular("(54)98143-4343");
		fornecedor.setTelefone("(54)3313-7777");
		fornecedor.setAtivo(true);
		assertNotNull(fornecedor);
		bo.insere(fornecedor);
	}
	
	@Test
	@Order(2)
	public void pesquisaPeloId() {
		Fornecedor fornecedor = bo.pesquisaPeloId(1L);
		assertNotNull(fornecedor);
		System.out.println(fornecedor);
	}
	
	@Test
	@Order(3)
	public void lista() {
		List<Fornecedor> fornecedores = bo.lista();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
	}
	
	@Test
	@Order(4)
	public void listaTodos() {
		List<Fornecedor> fornecedores = bo.listaTodos();
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
	}
	
	@Test
	@Order(5)
	public void atualiza() {
		Fornecedor fornecedor = bo.pesquisaPeloId(1L);
		fornecedor.setNomeFantasia("Novo Nome Fantasia");
		bo.atualiza(fornecedor);
	}
	
	@Test
	@Order(6)
	public void inativa() {
		Fornecedor fornecedor = bo.pesquisaPeloId(1L);
		bo.inativa(fornecedor);
	}
	
	@Test
	@Order(7)
	public void ativa() {
		Fornecedor fornecedor = bo.pesquisaPeloId(1L);
		bo.ativa(fornecedor);
	}
	
	@Test
	@Order(8)
	public void remove() {
		Fornecedor fornecedor = bo.pesquisaPeloId(1L);
		bo.remove(fornecedor);
	}
	
}