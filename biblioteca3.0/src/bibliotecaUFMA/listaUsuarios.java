package bibliotecaUFMA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class listaUsuarios extends JPanel implements ActionListener {
	String [] titulos = {"ID","Nome", "Debitos", "Livros Emp."};
	Object [][] conteudos;	
	JTable tabela;
	JScrollPane barraRolagem;
	private biblioteca b; 
	
	public listaUsuarios(biblioteca x){
		this.b = x;
		this.criarPainel();
		this.add(barraRolagem);
		this.setSize(500, 500);
		this.setVisible(true);	  	
	}
	
	private void criarPainel(){
	  tabela = null;
	  conteudos = new Object[b.getUsuarios().size()][4];
	  int contaLinha = 0;
	  
	  for(int key : b.getUsuarios().keySet()){
		 conteudos[contaLinha][0] = b.getUsuarios().get(key).getConta().getId();
		 conteudos[contaLinha][1] = b.getUsuarios().get(key).getNome();
		 
		 contaUsuario  conta = (contaUsuario) b.getUsuarios().get(key).getConta();
		 
		 conteudos[contaLinha][2] = conta.getDebitos();
		 conteudos[contaLinha][3] = conta.getEmpretimos().size();
		 
		 contaLinha += 1;
	  }
	  
	  tabela = new JTable(conteudos, titulos);
	  barraRolagem = new JScrollPane(tabela);
	}
	
@Override
  public void actionPerformed(ActionEvent evento) {
	
  }///fim
}
