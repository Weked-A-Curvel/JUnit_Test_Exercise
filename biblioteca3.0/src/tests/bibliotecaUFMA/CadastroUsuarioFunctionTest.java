package tests.bibliotecaUFMA;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bibliotecaUFMA.CadastroUsuarioFunction;
import bibliotecaUFMA.biblioteca;

public class CadastroUsuarioFunctionTest {
	biblioteca b;
	int senha;
	int id;
	String nome;
	String sobrenome;
	long cpf;
	CadastroUsuarioFunction funcao;
	
	
	@Before
	public void setUp() throws Exception {
		b = new biblioteca();
		funcao = new CadastroUsuarioFunction();
		
		senha = 1;
		id = 1;
		nome = "a";
		sobrenome = "b";
		cpf = 1;
	}

	@Test
	public void testCadastro() {
		assertTrue(funcao.cadastro(b, senha, id, nome, sobrenome, cpf));
		//fail("Not yet implemented");
		senha = 2;
		id = 2;
		
		assertTrue(funcao.cadastro(b, senha, id, nome, sobrenome, cpf));
	
		b = null;
		
		assertFalse(funcao.cadastro(b, senha, id, nome, sobrenome, cpf));
	}

}
