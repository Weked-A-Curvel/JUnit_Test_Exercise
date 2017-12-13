package tests.bibliotecaUFMA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bibliotecaUFMA.contaFuncionario;
// na verdade esta classe testa a funcao de autenticar da conta funcionario
// a funcao é analoga para a classe contausuario por isso nao houve necessidade do teste
// esse teste se deu pois o login usa esse metodo nativo das contas
class loginTestClass {
	contaFuncionario conta;
	
	@BeforeEach
	void setUp() throws Exception {
		conta = new contaFuncionario(1111, 1111);
	}

	@Test
	void testAutenticar() {
		//neste caso sabendo a conta tem-se o id do usuario, por sequencia falta a comparacao de senhas.
		assertTrue(conta.autenticar(1111), "login incorreto, teste falhou!");
		
		conta.setSenha(2222);
		
		assertFalse(conta.autenticar(1111), "login incorreto, teste falhou!");
		
		assertTrue(conta.autenticar(2222), "login incorreto, teste falhou!");
	}

}
