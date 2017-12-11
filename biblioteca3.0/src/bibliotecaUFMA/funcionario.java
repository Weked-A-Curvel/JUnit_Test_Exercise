package bibliotecaUFMA;

public class funcionario extends pessoa {
  private int matricula;
  
  funcionario(String nomeX, String sobrenomeX, long cpfX, conta contaX, int matriculaX) {
    super(nomeX, sobrenomeX, cpfX, contaX);
	this.setMatricula(matriculaX);
  }
  
  public int getMatriculo(){
	return this.matricula;  
  }
  
  public void setMatricula(int matriculaX){
	this.matricula = matriculaX;  
  }
  
}
