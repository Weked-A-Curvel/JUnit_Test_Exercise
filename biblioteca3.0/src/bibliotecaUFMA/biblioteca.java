package bibliotecaUFMA;
import java.util.HashMap;


public class biblioteca {
  private funcionario Funcionario;
  private HashMap <Integer,livro> livros = new HashMap<Integer, livro>();
  private HashMap <Integer,usuario> usuarios = new HashMap<Integer, usuario>();
  private HashMap <Integer,funcionario> funcionarios = new HashMap<Integer, funcionario>();   
  
  public biblioteca (/*HashMap<Integer, livro> livrosX, HashMap<Integer, usuario> usuariosX, HashMap <Integer,funcionario> funcionariosX*/ ){
	/*this.setLivros(livrosX);
	this.setUsuarios(usuariosX);
	this.setFuncionarios(funcionariosX);*/
  }
  
  public funcionario getFuncionario(){
	return this.Funcionario;  
  }
  
  public HashMap<Integer, livro> getLivros(){
	return this.livros;  
  }
  
  public HashMap<Integer,usuario> getUsuarios(){
	return this.usuarios;  
  }
  
  public HashMap<Integer, funcionario> getFuncionarios(){
	return this.funcionarios;  
  }
  
  public void setFuncionario (funcionario funcionarioX){
	this.Funcionario = funcionarioX;  
  }
  
  public void setLivros(HashMap<Integer, livro> livrosX){
	this.livros = livrosX;  
  }
  
  public void setUsuarios(HashMap<Integer,usuario> usuariosX){
	this.usuarios = usuariosX; 
  }
  
  public void setFuncionarios(HashMap<Integer, funcionario> funcionariosX){
	this.funcionarios = funcionariosX;  
  }
  
}