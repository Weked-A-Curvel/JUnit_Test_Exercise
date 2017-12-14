package tests.bibliotecaUFMA;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bibliotecaUFMA.DataControlClass;
import bibliotecaUFMA.biblioteca;

public class DataControlTest {
	DataControlClass control;
	biblioteca b;
	
	@Before
	public void setUp() throws Exception {
		control = new DataControlClass();
		b = new biblioteca();
	}
	
	//todas a funcoes a seguir se esperam que sua execucao 
	//retorne true, ou seja o procedimento foi bem executado
	
	@Test
	public void testCarregaDados() {
		assertNotNull(control.carregaDados(b));
		
		b = null;
		
		assertNull(control.carregaDados(b));
	}

	@Test
	public void testSalvaDados() {
		//ha uma nota sobre erro neste treco de codigo no arquivo datacontrolclass
		assertTrue(control.salvaDados(b));
		
		b = null;
		
		assertFalse(control.salvaDados(b));		
	}

	@Test
	public void testCarregaFuncionarios() {
		assertTrue(control.carregaFuncionarios());

	}

	@Test
	public void testCarregarLivros() {
		assertTrue(control.carregarLivros());

	}

	@Test
	public void testCarregaUsuarios() {
		assertTrue(control.carregaUsuarios());
		
	}

	@Test
	public void testSalvarFuncionarios() {
		assertTrue(control.salvarFuncionarios(b));

	}

	@Test
	public void testSalvarLivros() {
		assertTrue(control.salvarLivros(b));

	}

	@Test
	public void testSalvarUsuarios() {
		assertTrue(control.salvarUsuarios(b));

	}

}
