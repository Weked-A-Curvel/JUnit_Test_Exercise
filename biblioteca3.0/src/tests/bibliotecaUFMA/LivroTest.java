package tests.bibliotecaUFMA;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bibliotecaUFMA.livro;

public class LivroTest {
	livro exemplar;
	
	@Before
	public void setUp() throws Exception {
		exemplar = new livro("1", "1", 1, 1, 1);
		
	}

	@Test
	public void testGerarMulta() {
		//fail("Not yet implemented");
		float debito;
		
		debito = 0.50f;
		
		exemplar.setDiasEmpres(-1);
		
		assertEquals(debito, exemplar.gerarMulta());
		
		debito = 1.50f;
		
		exemplar.setDiasEmpres(-3);
		
		assertEquals(debito, exemplar.gerarMulta());
		
		//gerara falha, mas a falha aqui esta na forma de proceder com o teste
		//assertEquals(debito, exemplar.gerarMulta());
		
		//maneira correta de gerar os testes
		exemplar.setDiasEmpres(3);
		
		assertNotEquals(debito, exemplar.gerarMulta());
		
	}

}
