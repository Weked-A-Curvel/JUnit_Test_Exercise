package tests.bibliotecaUFMA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bibliotecaUFMA.DataControlClass;
import bibliotecaUFMA.FuncionarioPanel;
import bibliotecaUFMA.FuncionarioPanelFunction;
import bibliotecaUFMA.biblioteca;
import bibliotecaUFMA.contaUsuario;
import bibliotecaUFMA.livro;
import bibliotecaUFMA.usuario;
	
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
		
		//a ausencia de toda esta parte ira gerar uma excessao de ponteiro no segundo teste
		//onde uma validacao manual é requerida para o teste, assim como definir um valor invalido recair em uma parte nula dos dados
		//a solucao para o problema se encontra comentada na classe FuncionarioPanelFunction
		b.getUsuarios().put(1, new usuario("nome", "sobrenome", 005, 
				new contaUsuario(1, 1)));
		
		b.getLivros().put(1, new livro("titulo", "autor", 1, 1, 1));
	}

	@Test//dar uma olhada nesse teste, implementei uma solucao mais falta testar com calma
	void testEmprestimoDeLivro() {
	
		
		assertTrue(funcao.emprestimoDeLivro(b, funcionario));
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
