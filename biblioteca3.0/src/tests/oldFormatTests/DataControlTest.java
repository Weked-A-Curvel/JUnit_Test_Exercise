package tests.bibliotecaUFMA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bibliotecaUFMA.DataControlClass;
import bibliotecaUFMA.biblioteca;

class DataControlTest {
	DataControlClass control;
	biblioteca b;
	
	@BeforeEach
	void setUp() throws Exception {
		control = new DataControlClass();
		b = new biblioteca();
	}
	
	//todas a funcoes a seguir se esperam que sua execucao 
	//retorne true, ou seja o procedimento foi bem executado
	
	@Test
	void testCarregaDados() {
		assertNotNull(control.carregaDados(b));
		//fail("Not yet implemented");
	}

	@Test
	void testSalvaDados() {
		//ha uma nota sobre erro neste treco de codigo no arquivo datacontrolclass
		assertTrue(control.salvaDados(b));
		//fail("Not yet implemented");
	}

	@Test
	void testCarregaFuncionarios() {
		assertTrue(control.carregaFuncionarios());
		//fail("Not yet implemented");
	}

	@Test
	void testCarregarLivros() {
		assertTrue(control.carregarLivros());
		//fail("Not yet implemented");
	}

	@Test
	void testCarregaUsuarios() {
		assertTrue(control.carregaUsuarios());
		//fail("Not yet implemented");
	}

	@Test
	void testSalvarFuncionarios() {
		assertTrue(control.salvarFuncionarios(b));
		//fail("Not yet implemented");
	}

	@Test
	void testSalvarLivros() {
		assertTrue(control.salvarLivros(b));
		//fail("Not yet implemented");
	}

	@Test
	void testSalvarUsuarios() {
		assertTrue(control.salvarUsuarios(b));
		//fail("Not yet implemented");
	}

}
