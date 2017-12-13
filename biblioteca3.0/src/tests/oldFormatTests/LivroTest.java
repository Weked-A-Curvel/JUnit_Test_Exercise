package tests.bibliotecaUFMA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bibliotecaUFMA.livro;

class LivroTest {
	livro exemplar;
	
	@BeforeEach
	void setUp() throws Exception {
		exemplar = new livro("1", "1", 1, 1, 1);
		
	}

	@Test
	void testGerarMulta() {
		//fail("Not yet implemented");
		float debito;
		
		debito = 0.50f;
		
		exemplar.setDiasEmpres(-1);
		
		assertEquals(debito, exemplar.gerarMulta());
		
		exemplar.setDiasEmpres(3);
		
		//gerara falha, mas a falha aqui esta na forma de proceder com o teste
		//assertEquals(debito, exemplar.gerarMulta());
		
		//maneira correta de gerar os testes
		assertNotEquals(debito, exemplar.gerarMulta());
		
	}

}
