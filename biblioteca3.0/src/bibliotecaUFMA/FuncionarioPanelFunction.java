package bibliotecaUFMA;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FuncionarioPanelFunction {
	
	public boolean emprestimoDeLivro(biblioteca b, JPanel  p) {
	
		  int ref = Integer.parseInt(JOptionPane.showInputDialog("Ref. Do livro: "));
		  int id;
		  int senha;
		  //erro correcao//
		  //capturar a excessao de ponteiro nulo
		  try {
			  if(b != null) { //testar se a biblioteca é nula, so esse nao garante a excessao
				  	if(b.getLivros().get(ref).getQtd() > 0){	
				  		id = Integer.parseInt(JOptionPane.showInputDialog("ID do Usuario: ")); 
				  		senha = Integer.parseInt(JOptionPane.showInputDialog("Senha do Usuario: "));
				  		if(b.getUsuarios().get(id).getConta().autenticar(senha)){
				  			contaUsuario conta = (contaUsuario)b.getUsuarios().get(id).getConta(); 
				  			if(conta.getEmpretimos().size() == 0){
				  				conta.getEmpretimos().add(b.getLivros().get(ref));
				  				b.getLivros().get(ref).setQtd(b.getLivros().get(ref).getQtd() - 1);
				  				JOptionPane.showMessageDialog(p, String.format("Livro Emprestado!"));
				  			}else{
				  				boolean flag = true;	
				  				for(int i = 0; i < conta.getEmpretimos().size(); i++){
				  					if(conta.getEmpretimos().get(i).getRef() == ref){
				  						flag = false; 
				  						break; 
				  					} 
				  				}
				  				if(flag){
				  					conta.getEmpretimos().add(b.getLivros().get(ref));
				  					b.getLivros().get(ref).setQtd(b.getLivros().get(ref).getQtd() - 1); 
				  					JOptionPane.showMessageDialog(p, String.format("Livro Emprestado!"));
				  				}else{
				  					JOptionPane.showMessageDialog(p, String.format("Livro Ja Emprestado!")); 
				  				}
				  			}
				  		}else{
				  			JOptionPane.showMessageDialog(p, String.format("Tente novamente.\ninformacoes de Usuario incompativeis!!"));
				  			return false;
				  		}
				  	}	
				} //
		  }catch(Exception excessao){//
			  
		  }	//
		  	return true;
	}

	public int calculaEmprestimos(biblioteca b) {
		//int idTemp;
		int emprestimosTotal = 0;
		contaUsuario contaTmp;
		
		try {
			if(b != null) {
				for(int key : b.getUsuarios().keySet()){
					  //idTemp = (1001+i);
					  contaTmp = (contaUsuario) b.getUsuarios().get(key).getConta();
					  emprestimosTotal += contaTmp.getEmpretimos().size();
					}
			}
		}catch(Exception e) {}
		
		return emprestimosTotal;
	}
	
	public boolean atualizarEmprestimos(biblioteca b) {
		try {
			if(b != null) {
				for(int key : b.getUsuarios().keySet()){
					contaUsuario conta = (contaUsuario)b.getUsuarios().get(key).getConta();
					conta.atualizarEmprestimos();
					b.getUsuarios().get(key).setConta(conta);
				}
				return true;
			}
		}catch(Exception e) {}		

		return false;
	}
}