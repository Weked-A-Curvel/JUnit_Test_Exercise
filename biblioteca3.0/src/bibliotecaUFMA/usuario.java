package bibliotecaUFMA;

public class usuario extends pessoa {
  private boolean emprestar;//isto verificara se o usuario ainda pode emprstar ou nao livros
  
  public usuario(String nomeX, String sobrenomeX, long cpfX, conta contaX) {
	super(nomeX, sobrenomeX, cpfX, contaX);
	this.setEmprestar(true);
  }
  
  public boolean getEmprestar(){
	return this.emprestar;  
  }
  
  public void setEmprestar(boolean emprestarX){
	this.emprestar = emprestarX;  
  }
}
