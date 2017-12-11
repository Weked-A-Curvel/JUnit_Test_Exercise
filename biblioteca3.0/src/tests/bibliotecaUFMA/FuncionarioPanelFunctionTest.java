package tests.bibliotecaUFMA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bibliotecaUFMA.DataControlClass;
import bibliotecaUFMA.FuncionarioPanel;
import bibliotecaUFMA.FuncionarioPanelFunction;
import bibliotecaUFMA.biblioteca;
	
class FuncionarioPanelFunctionTest {
	FuncionarioPanel funcionario;
	FuncionarioPanelFunction funcao;
	biblioteca b;
	DataControlClass data;
	
	@BeforeEach
	void setUp() throws Exception {
		b = new biblioteca();
		funcionario = new FuncionarioPanel(b);
		funcao = new FuncionarioPanelFunction();
		data = new DataControlClass();
	}

	@Test//dar uma olhada nesse teste, implementei uma solucao mais falta testar com calma
	void testEmprestimoDeLivro() {
		assertFalse(funcao.emprestimoDeLivro(b, funcionario));
		//fail("Not yet implemented");
	}

	@Test
	void testCalculaEmprestimos() {
		assertEquals(0, funcao.calculaEmprestimos(b));
		//fail("Not yet implemented");
	}

	@Test
	void testAtualizarEmprestimos() {
		assertTrue(funcao.atualizarEmprestimos(b));
		//fail("Not yet implemented");
	}

}
