package bibliotecaUFMA;

public class contaFuncionario extends conta {

  public contaFuncionario(int senhaX, int idX) {
	super(senhaX, idX);		
  }

@Override
  public boolean autenticar(int senhaX) {
	if(senhaX == this.getSenha()){
	  return true;	
	}
  System.err.println("Senha Invalida!");	//esta mensagem de console tem que ser convertida para a janela
  return false;
  }  
}
