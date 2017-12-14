package bibliotecaUFMA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class DataControlClass {
	File arquivoFuncionarios;
	File arquivoUsuarios;
	File arquivoLivros;
	HashMap <Integer,livro>       livros;
	HashMap <Integer,usuario>     usuarios;
	HashMap <Integer,funcionario> funcionarios; 
	
	public biblioteca carregaDados(biblioteca Biblioteca) {
		try {
			if(Biblioteca != null) {
				if(this.carregaFuncionarios() && 
						this.carregarLivros() && 
							this.carregaUsuarios()) {
				
					Biblioteca.setFuncionarios(funcionarios);
					Biblioteca.setLivros(livros);
					Biblioteca.setUsuarios(usuarios);
					
					return Biblioteca;
				}
			}
		}catch(Exception e) {}
		
		return null;
	}
	
	public boolean salvaDados(biblioteca Biblioteca) {
		
		try {
			if(Biblioteca != null) {
				if (this.salvarFuncionarios(Biblioteca) && 
						this.salvarLivros(Biblioteca) &&
							this.salvarUsuarios(Biblioteca)) {
					return true;
				}
			}
		}catch(Exception e) {}
		
		//na compilacao do teste um trecho de codigo errado ira persistir um erro para o teste
		//return falsine;
		return false;
	}
	
	public boolean carregaFuncionarios() {
		
		arquivoFuncionarios = new File("arquivos\\funcionarios\\funcionarios.dat");
		
		//carregar funcionarios
		if(!arquivoFuncionarios.exists()){
		  funcionarios = new HashMap <Integer,funcionario>(); 	
		}else{
			try{
				funcionarios = new HashMap <Integer, funcionario>();
				Scanner inputFuncionarios = new Scanner(arquivoFuncionarios).useDelimiter("\\;|\\n");
				   
				while(inputFuncionarios.hasNext()){
					 String nome = inputFuncionarios.next(); 
					 String sobrenome = inputFuncionarios.next();
					 long cpf = inputFuncionarios.nextLong();
					 int matricula = inputFuncionarios.nextInt();
					 int id = inputFuncionarios.nextInt();
					 int senha = inputFuncionarios.nextInt();
					 
					 contaFuncionario conta = new contaFuncionario(senha, id);
					 funcionario novoF = new funcionario(nome, sobrenome, cpf, conta, matricula);
					 funcionarios.put(id, novoF);
				}
				inputFuncionarios.close();
				
			}catch(Exception excessao0){
				funcionarios = new HashMap <Integer, funcionario>();
				//mensagem de erro, no console apenas para fim de teste
				System.out.println("Erro ao Carregar funcionarios");
				
				return false;
			}
		}/////////////////fim do carregamento hash funcionarios
		
		return true;
	}
	
	public boolean carregarLivros() {
		
		arquivoLivros = new File("arquivos\\livros\\livros.dat");
		
		/////////////carregamento dos livros
		if(!arquivoLivros.exists()){
			livros = new HashMap<Integer, livro>();		
		}else{
			try{
				livros = new HashMap<Integer, livro>();	
				Scanner inputLivros = new Scanner(arquivoLivros).useDelimiter("\\;|\\n");
				
				while(inputLivros.hasNext()){
					String titulo = inputLivros.next();
					String autor = inputLivros.next();
					int ano = inputLivros.nextInt();
				    int ref = inputLivros.nextInt();
				    int qtd = inputLivros.nextInt();
				    
				    livro novo = new livro(titulo, autor, ano, ref, qtd);
				    livros.put(ref, novo);
				}
				inputLivros.close();
			}catch(Exception excessao2){
				livros = new HashMap<Integer, livro>();	
				//messagem de erro
				System.out.println("Erro ao Carregar Livros");
				
				return false;
			}		
		}////////////////fim da importacao livros
		
		return true;
	}
	
	public boolean carregaUsuarios() {
		
		arquivoUsuarios = new File("arquivos\\usuarios\\usuarios.dat");
		
		/////////carregamento de usuarios
		if(!arquivoUsuarios.exists()){
			usuarios = new HashMap<Integer, usuario>();	
		}else{
			try{
				usuarios = new HashMap<Integer, usuario>();	 
				Scanner inputUsuarios = new Scanner(arquivoUsuarios).useDelimiter("\\;|\\n");
				
				while(inputUsuarios.hasNext()){
					String nome = inputUsuarios.next();
					String sobrenome = inputUsuarios.next();
					long cpf = inputUsuarios.nextLong();
					int id = inputUsuarios.nextInt();
					int senha = inputUsuarios.nextInt();
					float debitos = inputUsuarios.nextFloat();
					int flag = inputUsuarios.nextInt();
					
					contaUsuario conta = new contaUsuario(id, senha);
					conta.setDebitos(debitos);
					//System.out.println("basico foi");
					for(int i = 0; i < flag; i++){
						int ref = inputUsuarios.nextInt();
						int diasEmp = inputUsuarios.nextInt();
						conta.getEmpretimos().add(livros.get(ref));
						conta.getEmpretimos().get(i).setDiasEmpres(diasEmp);
					}
					
					usuario novoU = new usuario(nome, sobrenome, cpf, conta);
					usuarios.put(id, novoU);
				}
				inputUsuarios.close();
			}catch(Exception excessao1){
				usuarios = new HashMap<Integer, usuario>();	 
				//menssagem de erro
				System.out.println("Erro ao Carregar usuarios");
				
				return false;
			}
		}/////////////////////fim do carregamento usuarios
		
		return true;
	}

	public boolean salvarFuncionarios(biblioteca Biblioteca) {
		 arquivoFuncionarios = new File("arquivos\\funcionarios\\funcionarios.dat");
		 
		 if(arquivoFuncionarios.exists()){
			   try{
				  if(arquivoFuncionarios.delete()){
					if(arquivoFuncionarios.createNewFile()){
						PrintWriter outputFuncionarios = new PrintWriter(arquivoFuncionarios);
						for(int chave : Biblioteca.getFuncionarios().keySet()){
							outputFuncionarios.print(Biblioteca.getFuncionarios().get(chave).getNome()      + ";");
							outputFuncionarios.print(Biblioteca.getFuncionarios().get(chave).getSobrenome() + ";");
							outputFuncionarios.print(Biblioteca.getFuncionarios().get(chave).getCpf()       + ";");
							outputFuncionarios.print(Biblioteca.getFuncionarios().get(chave).getMatriculo() + ";");
							outputFuncionarios.print(Biblioteca.getFuncionarios().get(chave).getConta().getId()    +  ";");
							outputFuncionarios.print(Biblioteca.getFuncionarios().get(chave).getConta().getSenha() + "\n");
						}
						outputFuncionarios.close();
					}  				
				  }//fim 
			   }catch(Exception excessao0){
				   //messagem de nao salvamento 
				   System.out.println("Erro ao Salvar funcionarios");
			   
				   return false;
			   }//////////////// 
			 }else{
				 try{
					 if(arquivoFuncionarios.createNewFile()){
						 PrintWriter outputFuncionarios = new PrintWriter(arquivoFuncionarios);
						 for(int chave : Biblioteca.getFuncionarios().keySet()){
							outputFuncionarios.print(Biblioteca.getFuncionarios().get(chave).getNome()      + ";");
							outputFuncionarios.print(Biblioteca.getFuncionarios().get(chave).getSobrenome() + ";");
							outputFuncionarios.print(Biblioteca.getFuncionarios().get(chave).getCpf()       + ";");
							outputFuncionarios.print(Biblioteca.getFuncionarios().get(chave).getMatriculo() + ";");
							outputFuncionarios.print(Biblioteca.getFuncionarios().get(chave).getConta().getId()    +  ";");
							outputFuncionarios.print(Biblioteca.getFuncionarios().get(chave).getConta().getSenha() + "\n");
						}
						outputFuncionarios.close(); 
					}
				 }catch(Exception excessao1){
					 //messsagem de nao salvamento
					 System.out.println("Erro ao Salvar funcionarios");
					 
					 return false;
				 }
			 }///fim da exportacao do funcionario
		 
		return true;
	}
	
	public boolean salvarLivros(biblioteca Biblioteca) {
		arquivoLivros = new File("arquivos\\livros\\livros.dat"); 
		
		 if(arquivoLivros.exists()){
				try{
					if(arquivoLivros.delete()){
					  if(arquivoLivros.createNewFile()){
						  PrintWriter outputLivros = new PrintWriter(arquivoLivros);
							for(int chave : Biblioteca.getLivros().keySet()){
								outputLivros.print(Biblioteca.getLivros().get(chave).getTitulo() + ";");
								outputLivros.print(Biblioteca.getLivros().get(chave).getAutor()  + ";");
								outputLivros.print(Biblioteca.getLivros().get(chave).getAno() + ";");
								outputLivros.print(Biblioteca.getLivros().get(chave).getRef() + ";");
								outputLivros.print(Biblioteca.getLivros().get(chave).getQtd() + ";");
							}
							outputLivros.close(); 
					  }	
					}
				}catch(Exception excessao0){
		       ////////menssagem de erro
					System.out.println("Erro ao Salvar funcionarios");
					
					return false;
				} 
			 }else{
				try{
					if(arquivoLivros.createNewFile()){
						  PrintWriter outputLivros = new PrintWriter(arquivoLivros);
							for(int chave : Biblioteca.getLivros().keySet()){
								outputLivros.print(Biblioteca.getLivros().get(chave).getTitulo() + ";");
								outputLivros.print(Biblioteca.getLivros().get(chave).getAutor()  + ";");
								outputLivros.print(Biblioteca.getLivros().get(chave).getAno() + ";");
								outputLivros.print(Biblioteca.getLivros().get(chave).getRef() + ";");
								outputLivros.print(Biblioteca.getLivros().get(chave).getQtd() + ";");
							}
							outputLivros.close(); 
					  }	
				}catch(Exception excessao1){
					/////////////////messagem de erro	
					System.out.println("Erro ao Salvar funcionarios");
				
					return false;
				}
			 }////////////fim da Exportacao livros
		return true;
	}
	
	public boolean salvarUsuarios(biblioteca Biblioteca) {
		arquivoUsuarios = new File("arquivos\\usuarios\\usuarios.dat");
		
		 if(arquivoUsuarios.exists()){
			   try{
				  if(arquivoUsuarios.delete()){
					if(arquivoUsuarios.createNewFile()){
						PrintWriter outputUsuarios = new PrintWriter(arquivoUsuarios);
						for(int chave : Biblioteca.getUsuarios().keySet()){
							outputUsuarios.print(Biblioteca.getUsuarios().get(chave).getNome()      + ";");
							outputUsuarios.print(Biblioteca.getUsuarios().get(chave).getSobrenome() + ";");
							outputUsuarios.print(Biblioteca.getUsuarios().get(chave).getCpf()       + ";");
							outputUsuarios.print(Biblioteca.getUsuarios().get(chave).getConta().getId()    + ";");
							outputUsuarios.print(Biblioteca.getUsuarios().get(chave).getConta().getSenha() + ";");
							contaUsuario conta = (contaUsuario)Biblioteca.getUsuarios().get(chave).getConta();
							String debitos = ""+conta.getDebitos();
							String tmp = debitos.replace(".", ",");
							outputUsuarios.print(tmp + ";");
							//flag no arquivo
							outputUsuarios.print(conta.getEmpretimos().size() + ";");//quantas interacoes seram feitas no carregamento
							for(int i = 0; i < conta.getEmpretimos().size(); i++){
							   outputUsuarios.print(conta.getEmpretimos().get(i).getRef() + ";");
							   outputUsuarios.print(conta.getEmpretimos().get(i).getDiasEmpres() + ";");
							}
							//outputUsuarios.print("\n");
						}
						outputUsuarios.close();
					}  				
				  }//fim 
			   }catch(Exception excessao0){
				   //messagem de nao salvamento 
				   System.out.println("Erro ao Salvar funcionarios");
			  
				   return false;
			   }//////////////// 
			 }else{
				 try{
					 if(arquivoUsuarios.createNewFile()){
							PrintWriter outputUsuarios = new PrintWriter(arquivoUsuarios);
							for(int chave : Biblioteca.getUsuarios().keySet()){
								outputUsuarios.print(Biblioteca.getUsuarios().get(chave).getNome()      + ";");
								outputUsuarios.print(Biblioteca.getUsuarios().get(chave).getSobrenome() + ";");
								outputUsuarios.print(Biblioteca.getUsuarios().get(chave).getCpf()       + ";");
								outputUsuarios.print(Biblioteca.getUsuarios().get(chave).getConta().getId()    + ";");
								outputUsuarios.print(Biblioteca.getUsuarios().get(chave).getConta().getSenha() + ";");
								contaUsuario conta = (contaUsuario)Biblioteca.getUsuarios().get(chave).getConta();
								String debitos = ""+conta.getDebitos();
								String tmp = debitos.replace(".", ",");
								outputUsuarios.print(tmp + ";");
								//flag no arquivo
								outputUsuarios.print(conta.getEmpretimos().size() + ";");//quantas interacoes seram feitas no carregamento
								for(int i = 0; i < conta.getEmpretimos().size(); i++){
								   outputUsuarios.print(conta.getEmpretimos().get(i).getRef() + ";");
								   outputUsuarios.print(conta.getEmpretimos().get(i).getDiasEmpres() + ";");
								}
								//outputUsuarios.print("\n");
							}
							outputUsuarios.close();
						} 
				 }catch(Exception excessao1){
					 //messsagem de nao salvamento
					 System.out.println("Erro ao Salvar funcionarios");
				 
					 return false;
				 }
			 }///fim da exportacao do livros
		return true;
	}
}
