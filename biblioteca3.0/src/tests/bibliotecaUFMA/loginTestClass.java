package tests.bibliotecaUFMA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bibliotecaUFMA.contaFuncionario;

class loginTestClass {
	contaFuncionario conta;
	
	@BeforeEach
	void setUp() throws Exception {
		conta = new contaFuncionario(1111, 1111);
	}

	@Test
	void testAutenticar() {
		assertTrue(conta.autenticar(1111), "login incorreto, teste falhou!");
	}

}
