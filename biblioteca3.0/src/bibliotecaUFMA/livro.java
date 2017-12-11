package bibliotecaUFMA;

public class livro {
  private String titulo;
  private String autor;
  private int ano;
  private int ref;
  private int qtd;
  private int diasEmpres;
  private boolean emprestar; 
  
  public livro(String tituloX, String autorX, int anoX, int refX, int qtdX){
	this.setTitulo(tituloX);
	this.setAutor(autorX);
	this.setAno(anoX);
	this.setRef(refX);
	this.setQtd(qtdX);
	this.setDiasEmpres(7);
	this.setEmprestar(true);
  }
  
  public String getTitulo(){
	return this.titulo;
  }
  
  public String getAutor(){
	return this.autor;
  }
  
  public int getAno(){
	return this.ano;  
  }
  
  public int getRef(){
	return this.ref;  
  }
  
  public int getQtd(){
	return this.qtd;
  }
  
  public int getDiasEmpres(){
	return this.diasEmpres;  
  }
  
  public boolean getEmprestar(){
	return this.emprestar;  
  }
  
  public void setTitulo(String tituloX){
	this.titulo = tituloX;  
  }
  
  public void setAutor(String autorX){
	this.autor = autorX;  
  }
  
  public void setAno(int anoX){
	this.ano = anoX;  
  }
  
  public void setRef(int refX){
	this.ref = refX;  
  }
  
  public void setQtd(int qtdX){
	this.qtd = qtdX;  
  }
  
  public void setDiasEmpres(int diasEmpresX){
	this.diasEmpres = diasEmpresX;   
  }
  
  public void setEmprestar(boolean emprestarX){
	this.emprestar = emprestarX;  
  }
  
  //metodos exclusivos desta classe em relacao ao cliente
  public float gerarMulta(){
	if(this.getDiasEmpres() < 0){
	  return 0.50f;
	}  
    return 0.0f; 
  }
}
