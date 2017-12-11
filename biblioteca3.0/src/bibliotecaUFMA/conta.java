package bibliotecaUFMA;

public abstract class conta {
  private int senha;
  private int id;
  
  conta(int senhaX, int idX){
	this.setId(idX);
	this.setSenha(senhaX);
  }
  
  public int getSenha(){
	return this.senha;  
  }
  
  public int getId(){
	return this.id;  
  }
  
  public void setSenha(int senhaX){
	this.senha = senhaX;  
  }
  
  public void setId(int idX){
	this.id = idX;  
  }
  
  public abstract boolean autenticar(int senhaX);
}
