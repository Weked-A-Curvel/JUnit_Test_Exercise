package bibliotecaUFMA;

public class pessoa {
  private String nome;
  private String sobrenome;
  private long cpf;
  private conta Conta;
  
  pessoa(String nomeX, String sobrenomeX, long cpfX, conta contaX){
	this.setNome(nomeX);
	this.setCpf(cpfX);
	this.setConta(contaX);
  }
  
  public String getNome(){
	return this.nome;  
  }
  
  public String getSobrenome(){
	return this.sobrenome;  
  }
  
  public long getCpf(){
	return this.cpf;  
  }
  
  public conta getConta(){
	return this.Conta;  
  }
  
  public void setNome(String nomeX){
	this.nome = nomeX;  
  }
  
  public void setSobrenome(String sobrenomeX){
	this.sobrenome = sobrenomeX;  
  }
  
  public void setCpf(long cpf){
	this.cpf = cpf;  
  }
  
  public void setConta(conta contaX){
	this.Conta = contaX;  
  }
}
