package bibliotecaUFMA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class listaLivrosPainel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String [] titulos = {"Ref","Titulo", "Autor", "Qtd"};
	Object [][] conteudos;
	private HashMap<Integer, livro> livro;
	JTable tabela;
	JScrollPane barraRolagem;
	
	public listaLivrosPainel(HashMap<Integer, livro> livro){
		this.livro = livro;
		this.criarPainel();
		this.add(barraRolagem);
		this.setSize(450, 250);
		this.setVisible(true);	  	
	}
	
	private void criarPainel(){
	  tabela = null;
	  conteudos = new Object[livro.size()][4];
	  int contaLinha = 0;
	  
	  for(int key : livro.keySet()){
		 conteudos[contaLinha][0] = livro.get(key).getRef();
		 conteudos[contaLinha][1] = livro.get(key).getTitulo();
		 conteudos[contaLinha][2] = livro.get(key).getAutor();
		 conteudos[contaLinha][3] = livro.get(key).getQtd();
		 //System.out.println(livro.get(key).getQtd());
		 //conteudos[contaLinha][4] = livro.get(key).getQtd();
		
		 contaLinha += 1;
	  }
	  
	  tabela = new JTable(conteudos, titulos);
	  barraRolagem = new JScrollPane(tabela);
	}
	
@Override
  public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
  }

}
