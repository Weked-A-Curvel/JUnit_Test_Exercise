package tests.bibliotecaUFMA;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CadastroUsuarioFunctionTest.class, DataControlTest.class, FuncionarioPanelFunctionTest.class,
		LivroTest.class, LoginTestClass.class })
public class GeneralTestSuite {

}
