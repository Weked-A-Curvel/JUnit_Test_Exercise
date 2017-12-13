package bibliotecaUFMA;

import java.util.ArrayList;

public class contaUsuario extends conta {
  private float debitos;
  private ArrayList <livro> emprestimos = new ArrayList <livro>();

  public contaUsuario(int senhaX, int idX) {
	super(senhaX, idX);	
	this.setDebitos(0.0f);
  }

  public float getDebitos(){
	return this.debitos;  
  }
  
  public ArrayList<livro> getEmpretimos(){
	return this.emprestimos;  
  }
  
  public void setDebitos(float debitosX){
	this.debitos = debitosX;  
  }
  
  public void setEmpretimos(ArrayList<livro> emprestimosX){
	this.emprestimos = emprestimosX;  
  }
  
  public void atualizarEmprestimos(){
	for(int i = 0; i < this.emprestimos.size(); i++){
	  this.emprestimos.get(i).setDiasEmpres(this.emprestimos.get(i).getDiasEmpres()-1);	
	  if(this.emprestimos.get(i).getDiasEmpres() < 0){
		this.setDebitos(this.getDebitos() + this.emprestimos.get(i).gerarMulta());  
	  }
	}  
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
