package bibliotecaUFMA;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class cadastroLivro extends JPanel implements ActionListener {
	  /**
	 * 
	 */
	  private static final long serialVersionUID = 1L;
	  private JLabel cadastro; 
	  private JLabel titulo;
	  private JLabel autor;
	  private JLabel ano;
	  private JLabel ref;
	  private JLabel qtd;
	  private JTextField campoTitulo;
	  private JTextField campoAutor;
	  private JTextField campoAno;
	  private JTextField campoRef;
	  private JTextField campoQtd;
	  private JButton btCadastro;
	  private SpringLayout layout;
	  private biblioteca b;
		
	  public cadastroLivro(biblioteca x){
		this.b = x;  
		this.setSize(500, 500);
		this.componentes();
		this.setLayout(layout);
	  }	
	  
	  public void componentes(){
		layout = new SpringLayout();
		cadastro = new JLabel ("Cadastro De Obras: ");
		titulo = new JLabel("Titulo: ");
		autor = new JLabel("Autor: ");
		ano = new JLabel ("Ano: ");
		ref = new JLabel("REF.: ");
		qtd = new JLabel("Qtd.: ");
		campoTitulo = new JTextField(20);
		campoAutor = new JTextField(20);
		campoAno = new JTextField(11);
		campoRef = new JTextField(5);
		campoQtd = new JTextField(3);
		btCadastro = new JButton("Cadastrar");
		
		btCadastro.addActionListener(this);
		cadastro.setFont(new Font("Arial",0 , 18));
		
		this.add(cadastro);
		this.add(titulo);
		this.add(campoTitulo);
		this.add(autor);
		this.add(ano);
		this.add(campoAno);
		this.add(campoAutor);
		this.add(ref);
		this.add(campoRef);
		this.add(qtd);
		this.add(campoQtd);
		this.add(btCadastro);
		
		//tip Texts
		titulo.setToolTipText("Digite ao Lado O Titulo do Livro");
		campoTitulo.setToolTipText("Digite Aqui O Titulo do Livro");
		autor.setToolTipText("Digite ao Lado O Autor do Livro");
		campoAutor.setToolTipText("Digite Aqui O Autor do Livro");
		ano.setToolTipText("Digite ao Lado O Ano do Livro");
		campoAno.setToolTipText("Digite Aqui O Ano do Livro");
		ref.setToolTipText("Digite ao Lado A Referencia do Livro");
		campoRef.setToolTipText("Digite Aqui A Referencia do Livro");
		qtd.setToolTipText("Digite ao Lado A Quatidade de Livros");
		campoQtd.setToolTipText("Digite Aqui A Quantidade de Livros");
		btCadastro.setToolTipText("Informe Os Dados Acima e Clique Aqui Para Cadastrar O Livro");
		
		
		
		layout.putConstraint(SpringLayout.WEST, cadastro, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, cadastro, 10, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, titulo, 20, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, titulo, 40, SpringLayout.SOUTH, cadastro);
		
		layout.putConstraint(SpringLayout.WEST, campoTitulo, 5, SpringLayout.EAST, titulo);
		layout.putConstraint(SpringLayout.NORTH, campoTitulo, 40, SpringLayout.SOUTH, cadastro);
		
		layout.putConstraint(SpringLayout.WEST, autor, 20, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, autor, 10, SpringLayout.SOUTH, titulo);
			
		layout.putConstraint(SpringLayout.WEST, campoAutor, 5, SpringLayout.EAST, autor);
		layout.putConstraint(SpringLayout.NORTH, campoAutor, 10, SpringLayout.SOUTH, titulo);
		
		layout.putConstraint(SpringLayout.WEST, ano, 30, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ano, 10, SpringLayout.SOUTH, autor);
		
		layout.putConstraint(SpringLayout.WEST, campoAno, 5, SpringLayout.EAST, ano);
		layout.putConstraint(SpringLayout.NORTH, campoAno, 10, SpringLayout.SOUTH, autor);
		
		layout.putConstraint(SpringLayout.WEST, ref, 5, SpringLayout.EAST, campoAno);
		layout.putConstraint(SpringLayout.NORTH, ref, 10, SpringLayout.SOUTH, autor);
		
		layout.putConstraint(SpringLayout.WEST, campoRef, 5, SpringLayout.EAST, ref);
		layout.putConstraint(SpringLayout.NORTH, campoRef, 10, SpringLayout.SOUTH, autor);
		
		layout.putConstraint(SpringLayout.WEST, qtd, 30, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, qtd, 10, SpringLayout.SOUTH, ano);
		
		layout.putConstraint(SpringLayout.WEST, campoQtd, 5, SpringLayout.EAST, qtd);
		layout.putConstraint(SpringLayout.NORTH, campoQtd, 10, SpringLayout.SOUTH, ano);	
		
		layout.putConstraint(SpringLayout.EAST, btCadastro, 0, SpringLayout.EAST, campoRef);
		layout.putConstraint(SpringLayout.NORTH, btCadastro, 10, SpringLayout.SOUTH, campoQtd);
	  }
	@Override
	  public void actionPerformed(ActionEvent evento) {	
		if(evento.getSource() == btCadastro){
			try{
				String titulo = campoTitulo.getText();
				String autor = campoAutor.getText();
				int ano = Integer.parseInt(campoAno.getText());
				int ref = Integer.parseInt(campoRef.getText());
				int qtd = Integer.parseInt(campoQtd.getText());
				
				livro novo = new livro(titulo, autor, ano, ref, qtd);
				
				if(b.getLivros().put(ref, novo) != null){
					JOptionPane.showMessageDialog(this, String.format("Livro Adicionado!!!"));			
		            campoTitulo.setText("");
		            campoAutor.setText("");
		            campoAno.setText("");
		            campoRef.setText("");
		            campoQtd.setText("");
				}
			}catch(Exception excessao){
				JOptionPane.showMessageDialog(this, String.format("Verifique os Campos!\nInforme Corretamente, \ne Tente Novamente!")); 	
			}	
		}		
	  }//fim da funcao
}
