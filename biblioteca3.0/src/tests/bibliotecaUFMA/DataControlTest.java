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

	@Test
	void testCarregaDados() {
		assertNotNull(control.carregaDados(b));
		//fail("Not yet implemented");
	}

	@Test
	void testSalvaDados() {
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
