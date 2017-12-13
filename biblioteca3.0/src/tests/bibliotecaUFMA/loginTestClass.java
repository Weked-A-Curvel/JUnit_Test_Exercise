package tests.bibliotecaUFMA;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import bibliotecaUFMA.contaFuncionario;

//na verdade esta classe testa a funcao de autenticar da conta funcionario
//a funcao é analoga para a classe contausuario por isso nao houve necessidade do teste
//esse teste se deu pois o login usa esse metodo nativo das contas

public class LoginTestClass {
	contaFuncionario conta;
	
	@Before
	public void setUp() throws Exception {
		conta = new contaFuncionario(1111, 1111);
	}

	@Test
	public void testAutenticar() {
		//neste caso sabendo a conta tem-se o id do usuario, por sequencia falta a comparacao de senhas.
		assertTrue(conta.autenticar(1111), "login incorreto, teste falhou!");
		
		conta.setSenha(2222);
		
		assertFalse(conta.autenticar(1111), "login incorreto, teste falhou!");
		
		assertTrue(conta.autenticar(2222), "login incorreto, teste falhou!");
	}

}
