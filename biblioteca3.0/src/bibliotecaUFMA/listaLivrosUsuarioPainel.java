package bibliotecaUFMA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//import javax.swing.SpringLayout;

public class listaLivrosUsuarioPainel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String [] titulos = {"Ref","Titulo", "Autor", "DiasRes."};
	Object [][] conteudos;	
	JTable tabela;
	JScrollPane barraRolagem;
	JButton btRenovar = new JButton("Renovar");
	JButton btRenovarTodos = new JButton("Renovar Todos");
	JButton btDevolver = new JButton("Devolver");
	private ArrayList<livro> livro;
	private biblioteca b;
	int id;
	contaUsuario user; 
	
	public listaLivrosUsuarioPainel(biblioteca x, int id){
		//this.livro = livro;
		this.b = x;
		this.id = id;
		this.user = (contaUsuario)b.getUsuarios().get(this.id).getConta();
		this.livro = user.getEmpretimos();
		this.criarPainel();
		this.add(barraRolagem);
		this.add(btRenovar);
		this.add(btRenovarTodos);
		this.add(btDevolver);
		this.setSize(500, 500);
		this.setVisible(true);	  	
	}
	
	private void criarPainel(){
	  tabela = null;
	  conteudos = new Object[livro.size()][4];
	  
	  btRenovar.addActionListener(this);
	  btRenovarTodos.addActionListener(this);
	  btDevolver.addActionListener(this);
	  
	  btRenovar.setToolTipText("Selecione um livro, Depois Clique Aqui Para Renova-lo");
	  btRenovarTodos.setToolTipText("Clique Aqui Para Todos Os Livros Da Lista");
	  btRenovar.setToolTipText("Selecione um livro, Depois Clique Aqui Para Devolver");
	  
	  for(int i = 0; i < livro.size(); i++){
		 conteudos[i][0] = livro.get(i).getRef();
		 conteudos[i][1] = livro.get(i).getTitulo();
		 conteudos[i][2] = livro.get(i).getAutor();
		 conteudos[i][3] = livro.get(i).getDiasEmpres();
		 //System.out.println(livro.get(key).getQtd());
		 //conteudos[contaLinha][4] = livro.get(key).getQtd();
	  }
	  
	  tabela = new JTable(conteudos, titulos);
	  barraRolagem = new JScrollPane(tabela);
	}
	
@Override
  public void actionPerformed(ActionEvent evento) {
	if(evento.getSource() == btRenovar){
	  try{
		  int i = tabela.getSelectedRow();
		  //System.out.print(i);
		  if(livro.get(i).getDiasEmpres() >= 0){
			  livro.get(i).setDiasEmpres(7);
			  user.setEmpretimos(livro);
			  b.getUsuarios().get(id).setConta(user);
			  JOptionPane.showMessageDialog(this, String.format("Livro Renovados!"));
		  }else{
			  JOptionPane.showMessageDialog(this, String.format("Livro Atrasado!")); 
		  } 
	  }catch(Exception excessao){
		  JOptionPane.showMessageDialog(this, String.format("Tarefa nao pode ser Realizada!"));
	  }	
	}//fim
	
	if(evento.getSource() == btRenovarTodos){
	  try{
		  boolean flag = false;
		  for(int i = 0; i < livro.size(); i++){
			 if(livro.get(i).getDiasEmpres() >= 0){
				flag = true; 
			 }else{
				flag = false;
				break;
			 }  
		  }
		  
		  if(flag){
			  for(int i = 0; i < livro.size(); i++){
				livro.get(i).setDiasEmpres(7);  
			  }
			  user.setEmpretimos(livro);
			  b.getUsuarios().get(id).setConta(user);
			  JOptionPane.showMessageDialog(this, String.format("Livros Renovados!"));
		  }else{
			  JOptionPane.showMessageDialog(this, String.format("Livros nao Podem ser renovados\nou Nao Existem!"));
		  } 
	  }catch(Exception excessao){
		  JOptionPane.showMessageDialog(this, String.format("Tarefa nao pode ser Realizada!")); 
	  }	  
	}	
	
	if(evento.getSource() == btDevolver){
		try{		
			  int i = tabela.getSelectedRow();
			  //System.out.print(i);
			  b.getLivros().get(livro.get(i).getRef()).setQtd(b.getLivros().get(livro.get(i).getRef()).getQtd() +1);
			  livro.remove(i);
			  user.setEmpretimos(livro);
			  b.getUsuarios().get(id).setConta(user);
			  JOptionPane.showMessageDialog(this, String.format("Livros Devolvido!"));	
			  this.criarPainel();
		  }catch(Exception excessao){
			  JOptionPane.showMessageDialog(this, String.format("Tarefa nao pode ser Realizada!"));
		  }	
	}
	
  }///fim

}
