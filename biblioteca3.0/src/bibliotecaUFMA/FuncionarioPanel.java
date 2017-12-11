package bibliotecaUFMA;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class FuncionarioPanel extends JPanel implements ActionListener {
	  /**
	 * 
	 */
	  private static final long serialVersionUID = 1L;
	  private JButton btCalcEmprestimos;  
	  private JButton btRenovar;
	  private JButton btCalcDebitos;
	  private JButton btAcervo;
	  private JButton btCadUser;
	  private JButton btAtualizar;
	  private JButton btCadLivro;
	  private JButton btRemoveDbt;
	  private JButton btEmpresLivro;
	  private JButton btListarUsuario;
	  private ImageIcon atualizar;
	  private ImageIcon renovar;
	  private ImageIcon calcEmprestimos;
	  private ImageIcon calcDebitos;
	  private ImageIcon acervo;
	  private ImageIcon cadUser;
	  private ImageIcon cadLivro;
	  private ImageIcon removeDbt;
	  private ImageIcon EpresLivro;
	  private ImageIcon listaUsuario;
	  private JLabel logo;
	  private JLabel ver;
	  private SpringLayout layout;	
	  private biblioteca b;
	  private FuncionarioPanelFunction functions;
	  
	  public FuncionarioPanel(biblioteca x){
		this.b = x;  
		this.setSize(500, 500);
		this.componentes();
		this.setLayout(layout);
	  }	
	  
	  public void componentes(){
		layout = new SpringLayout();
		logo = new JLabel("M.S.B - MINI SISTEMA DE BIBLIOTECA");
		ver = new JLabel("ver. 0.0.3");
		//importando os incones
		atualizar = new ImageIcon("arquivos\\imagens\\botao\\btAtualizrar.jpg");
		renovar = new ImageIcon("arquivos\\imagens\\botao\\btRenovarLivros.jpg");
		calcEmprestimos = new ImageIcon("arquivos\\imagens\\botao\\btCalcEmprestimos.png");
		calcDebitos = new ImageIcon("arquivos\\imagens\\botao\\btCalcDebitos.png");
		acervo = new ImageIcon("arquivos\\imagens\\botao\\btAcervo.png");
		cadUser = new ImageIcon("arquivos\\imagens\\botao\\btCadUsuario.png");
		cadLivro = new ImageIcon("arquivos\\imagens\\botao\\btCadastrarLivro.png");
		removeDbt = new ImageIcon("arquivos\\imagens\\botao\\btRemoverDebitos.png");
		EpresLivro = new ImageIcon("arquivos\\imagens\\botao\\btEmprestar.png");
		listaUsuario = new ImageIcon("arquivos\\imagens\\botao\\btListarUsuarios.png");
		//setando so atributos para os botoes
		btCalcEmprestimos = new JButton("Total Emprs", calcEmprestimos);
		btRenovar = new JButton("Renovar", renovar);
		btCalcDebitos = new JButton("Debitos",calcDebitos);
		btAcervo = new JButton("Acervo", acervo);
		btRemoveDbt = new JButton("Rem. Debts", removeDbt);
		btCadUser = new JButton("Cad. Usuario", cadUser);
		btAtualizar = new JButton("Atualizar", atualizar);
		btCadLivro = new JButton("Cad. Livro", cadLivro);
		btEmpresLivro = new JButton("Emprestar", EpresLivro);
		btListarUsuario = new JButton("Lista Usuarios", listaUsuario);
		
		///////////
		functions =  new FuncionarioPanelFunction();
		
		//constantes de alinhamento tamanho e fonte dos botoes
		int constanteN = 130;
		int tamA = 115;
		int tamB = 75;
		String fonte = "Arial";
		int estilo = Font.TYPE1_FONT;
		int tamanho = 10;
		Font fnt = new Font(fonte, estilo, tamanho);
		
		//tamanho dos botoes
		//bt calc emprestimos
		btCalcEmprestimos.setMaximumSize(new Dimension(tamA, tamB));
		btCalcEmprestimos.setMinimumSize(new Dimension(tamA, tamB));
		btCalcEmprestimos.setPreferredSize(new Dimension(tamA, tamB));
		btCalcEmprestimos.setFont(fnt);
		//renovar
		btRenovar.setMaximumSize(new Dimension(tamA, tamB));
		btRenovar.setMinimumSize(new Dimension(tamA, tamB));
		btRenovar.setPreferredSize(new Dimension(tamA, tamB));
		btRenovar.setFont(fnt);
		//debitos
		btCalcDebitos.setMaximumSize(new Dimension(tamA, tamB));
		btCalcDebitos.setMinimumSize(new Dimension(tamA, tamB));
		btCalcDebitos.setPreferredSize(new Dimension(tamA, tamB));
		btCalcDebitos.setFont(fnt);
		//acervo
		btAcervo.setMaximumSize(new Dimension(tamA, tamB));
		btAcervo.setMinimumSize(new Dimension(tamA, tamB));
		btAcervo.setPreferredSize(new Dimension(tamA, tamB));
		btAcervo.setFont(fnt);
		//remover debitos
		btRemoveDbt.setMaximumSize(new Dimension(tamA, tamB));
		btRemoveDbt.setMinimumSize(new Dimension(tamA, tamB));
		btRemoveDbt.setPreferredSize(new Dimension(tamA, tamB));
		btRemoveDbt.setFont(fnt);
		//cadastro de usuario
		btCadUser.setMaximumSize(new Dimension(tamA, tamB));
		btCadUser.setMinimumSize(new Dimension(tamA, tamB));
		btCadUser.setPreferredSize(new Dimension(tamA, tamB));
		btCadUser.setFont(fnt);
		//atualizar
		btAtualizar.setMaximumSize(new Dimension(tamA, tamB));
		btAtualizar.setMinimumSize(new Dimension(tamA, tamB));
		btAtualizar.setPreferredSize(new Dimension(tamA, tamB));
		btAtualizar.setFont(fnt);
		//cadastro de livro
		btCadLivro.setMaximumSize(new Dimension(tamA, tamB));
		btCadLivro.setMinimumSize(new Dimension(tamA, tamB));
		btCadLivro.setPreferredSize(new Dimension(tamA, tamB));
		btCadLivro.setFont(fnt);
		//emprestimo de livro
		btEmpresLivro.setMaximumSize(new Dimension(tamA, tamB));
		btEmpresLivro.setMinimumSize(new Dimension(tamA, tamB));
		btEmpresLivro.setPreferredSize(new Dimension(tamA, tamB));
		btEmpresLivro.setFont(fnt);
		//listar Usuario
		btListarUsuario.setMaximumSize(new Dimension(tamA, tamB));
		btListarUsuario.setMinimumSize(new Dimension(tamA, tamB));
		btListarUsuario.setPreferredSize(new Dimension(tamA, tamB));
		btListarUsuario.setFont(fnt);
		
		//setando os listeners
		btCalcEmprestimos.addActionListener(this);
		btRenovar.addActionListener(this);
		btAcervo.addActionListener(this);
		btCalcDebitos.addActionListener(this);
		btRemoveDbt.addActionListener(this);
		btCadUser.addActionListener(this);
		btAtualizar.addActionListener(this);
		btCadLivro.addActionListener(this);
		btEmpresLivro.addActionListener(this);
		btListarUsuario.addActionListener(this);
		
		//setando valores de fonte para logo
		logo.setFont(new Font("Arial",0 , 22));
		ver.setFont(new Font(Font.MONOSPACED,0 , 11));
		
		//add ao painel 
		this.add(logo);
		this.add(ver);
		this.add(btCalcEmprestimos);//
		this.add(btRenovar);
		this.add(btAcervo);
		this.add(btCalcDebitos);//
		this.add(btRemoveDbt);
		this.add(btCadUser);//
		this.add(btAtualizar);//
		this.add(btCadLivro);//
		this.add(btEmpresLivro);
		this.add(btListarUsuario);
		
		//tip Texts
		btCalcEmprestimos.setToolTipText("Calcula A Quantidade De Livros Emprestados");
		btRenovar.setToolTipText("Renova O/Os Livros Que Um Usuario Tenha Emprestado");
		btCalcDebitos.setToolTipText("Calcula A Quantidade De Debitos em Atraso dos Usuarios");
		btAcervo.setToolTipText("Lista Todos Os Livros Cadastrados");
		btRemoveDbt.setToolTipText("Remove Os Debitos De Um Usuario");
		btCadUser.setToolTipText("Cadastra Um Novo Usuario");
		btAtualizar.setToolTipText("Atualiza Os Emprestimos dos Usuario em 1(um) Dia");
		btCadLivro.setToolTipText("Cadastra Um Novo Livro");
		btEmpresLivro.setToolTipText("Empresta Um Livro Do Acervo");
		btListarUsuario.setToolTipText("Lista Todos Os Usuarios Cadastrados No Sistema");
		
		//localizacao do logo
		layout.putConstraint(SpringLayout.WEST,  logo, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH,  logo, 50, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.EAST,  ver, 0, SpringLayout.EAST, logo);
		layout.putConstraint(SpringLayout.NORTH,  ver, 0, SpringLayout.SOUTH, logo);
		//setando as localizacoes para cada botao
		layout.putConstraint(SpringLayout.WEST, btAtualizar, 13, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btAtualizar, constanteN, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btAcervo, 0, SpringLayout.EAST, btAtualizar);
		layout.putConstraint(SpringLayout.NORTH, btAcervo, constanteN, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btCalcEmprestimos, 0, SpringLayout.EAST, btAcervo);//
		layout.putConstraint(SpringLayout.NORTH, btCalcEmprestimos, constanteN, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btCalcDebitos, 0, SpringLayout.EAST, btCalcEmprestimos);
		layout.putConstraint(SpringLayout.NORTH, btCalcDebitos, constanteN, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btRenovar, 13, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btRenovar, 10, SpringLayout.SOUTH, btAtualizar);
		
		layout.putConstraint(SpringLayout.WEST, btCadUser, 0, SpringLayout.EAST, btRenovar);
		layout.putConstraint(SpringLayout.NORTH, btCadUser, 10, SpringLayout.SOUTH, btAtualizar);
		
		layout.putConstraint(SpringLayout.WEST, btCadLivro, 0, SpringLayout.EAST, btCadUser);
		layout.putConstraint(SpringLayout.NORTH, btCadLivro, 10, SpringLayout.SOUTH, btAtualizar);
		
		layout.putConstraint(SpringLayout.WEST, btRemoveDbt, 0, SpringLayout.EAST, btCadLivro);//
		layout.putConstraint(SpringLayout.NORTH, btRemoveDbt, 10, SpringLayout.SOUTH, btAtualizar);
		
		layout.putConstraint(SpringLayout.WEST, btListarUsuario, 130, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btListarUsuario, 10, SpringLayout.SOUTH, btRemoveDbt);
		
		layout.putConstraint(SpringLayout.WEST, btEmpresLivro, 0, SpringLayout.EAST, btListarUsuario);//
		layout.putConstraint(SpringLayout.NORTH, btEmpresLivro, 10, SpringLayout.SOUTH, btRemoveDbt);
		
	  }
	  
	  //metodo performed para os botoes e seus respectivos eventos
	@Override
	  public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == btCalcEmprestimos){
		  try{			
			//int idTemp;
			int emprestimosTotal = 0;
			
			emprestimosTotal = functions.calculaEmprestimos(b);
			/*contaUsuario contaTmp;
			 
			for(int key : b.getUsuarios().keySet()){
			  //idTemp = (1001+i);
			  contaTmp = (contaUsuario) this.b.getUsuarios().get(key).getConta();
			  emprestimosTotal += contaTmp.getEmpretimos().size();
			}*/	
			    
			JOptionPane.showMessageDialog(this, String.format(""+ emprestimosTotal)); 
				
		    }catch(Exception excessao0){
			  JOptionPane.showMessageDialog(this, String.format("Ipossivel realizar a tarefa")); 
		    }	
	    }
		//////////////////////////////
		if(evento.getSource() == btCalcDebitos){
		  try{
			//int idTemp;
			float debitosTotal = 0.0f;
			contaUsuario contaTmp;
				
			for(int key : b.getUsuarios().keySet()){
			  //idTemp =(1001+i);
			  contaTmp = (contaUsuario) this.b.getUsuarios().get(key).getConta();
			  debitosTotal += contaTmp.getDebitos(); 
			}
			  JOptionPane.showMessageDialog(this, String.format(""+ debitosTotal));   
		  }catch(Exception excessao1){
			  JOptionPane.showMessageDialog(this, String.format("Ipossivel realizar a tarefa"));  
		  }	
		}
		///////////////////cadastrar usuario//////////////////////
		if(evento.getSource() == btCadUser){
		  JFrame JanelaCadastro = new JFrame("Cadastro de Usuario");
		  
		  JanelaCadastro.add(new cadastroUsuario(b));
		  JanelaCadastro.setVisible(true);
		  JanelaCadastro.setResizable(false);
		  JanelaCadastro.setSize(460,300);
		  JanelaCadastro.setLocation(450, 200);
		  /*aplicativo.telaPrincipal.remove(aplicativo.painel);	
		  aplicativo.painel = new cadastroUsuario(b);
		  aplicativo.telaPrincipal.add(aplicativo.painel);
		  aplicativo.telaPrincipal.repaint();
		  aplicativo.telaPrincipal.setVisible(true);*/
		}
		//////////////////atuializar contas//////////////////////
		if(evento.getSource() == btAtualizar){//esse botao vai sair
		  try{
			  /*for(int key : b.getUsuarios().keySet()){
				 contaUsuario conta = (contaUsuario)b.getUsuarios().get(key).getConta();
				 conta.atualizarEmprestimos();
				 b.getUsuarios().get(key).setConta(conta);
			  }*/
			  if(functions.atualizarEmprestimos(b)) {
				  JOptionPane.showMessageDialog(this, String.format("Emprestimos Atualizados!!!"));
				  btAtualizar.setEnabled(false); //isto e apenas para ilustrar como seria um dia logado, se torna impossivel atualizar denovo e lesar o usuario
			  }else {
				  JOptionPane.showMessageDialog(this, String.format("Um Problema Ocorreu na recuperação de Informações!"));
			  }
			  }catch(Exception excesssao){
			  
		  }  
			
		/*aplicativo.telaPrincipal.remove(aplicativo.painel);	
		  aplicativo.painel = new cadastroFuncionario(b);
		  aplicativo.telaPrincipal.add(aplicativo.painel);
		  aplicativo.telaPrincipal.repaint();
		  aplicativo.telaPrincipal.setVisible(true);*/	
		}
		//////////////////cadastrar livro//////////////////////////
		if(evento.getSource() == btCadLivro){
		  JFrame JanelaCadastro = new JFrame("Cadastro de Livros");
			  
		  JanelaCadastro.add(new cadastroLivro(b));
		  JanelaCadastro.setVisible(true);
		  JanelaCadastro.setResizable(false);
		  JanelaCadastro.setSize(460,250);
		  JanelaCadastro.setLocation(450, 250);	
			
		  /*aplicativo.telaPrincipal.remove(aplicativo.painel);	
		  aplicativo.painel = new cadastroLivro(b);
		  aplicativo.telaPrincipal.add(aplicativo.painel);
		  aplicativo.telaPrincipal.repaint();
		  aplicativo.telaPrincipal.setVisible(true);*/	
		}
		//////////////////renovar livro//////////////////////////
		if(evento.getSource() == btRenovar){
			try{
			    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do Usuario: ")); 
			    int senha = Integer.parseInt(JOptionPane.showInputDialog("Senha do Usuario: "));
			    //verificando os dados
			    if(b.getUsuarios().get(id).getConta().autenticar(senha)){
			    	JFrame JanelaLista = new JFrame("Emprestimos do usuario " + b.getUsuarios().get(id).getNome());
					  
			    	JanelaLista.add(new listaLivrosUsuarioPainel(b, id));
			    	JanelaLista.setVisible(true);
			    	JanelaLista.setSize(500,500);
			    	JanelaLista.setLocation(450, 250);		      
			    }
			 }catch(Exception excesao){
				 JOptionPane.showMessageDialog(this, String.format("Tente novamente, informacoes incompativeis!!"));
			 }
		}
			
			/*try{
			 int id = Integer.parseInt(JOptionPane.showInputDialog("ID do Usuario: ")); 
			 int senha = Integer.parseInt(JOptionPane.showInputDialog("Senha do Usuario: "));
			 //verificando os dados
			 if(b.getUsuarios().get(id).getConta().autenticar(senha)){
			   //tem que setar e devolver a conta
			   contaUsuario conta = (contaUsuario)b.getUsuarios().get(id).getConta();
			   for(int i = 0; i < conta.getEmpretimos().size(); i++){
				  if(conta.getEmpretimos().get(i).getDiasEmpres() <= 0){
				    conta.getEmpretimos().get(i).setDiasEmpres(7);
				  }
			   }
			 }			 
		  }catch(Exception excessao2){
			 JOptionPane.showMessageDialog(this, String.format("Tente novamente, informacoes incompativeis!!")); 
		  }*/ 	
		
		/////////////////pesquisar livro///////////////////////////////
		if(evento.getSource() == btAcervo){
			//seta o titulo da janela
			JFrame JanelaLista = new JFrame("Mostra do Acervo");
			
			//adicao do painel e configuracoes gerais do JFrame
			JanelaLista.add(new listaLivrosPainel(b.getLivros()));
			JanelaLista.setVisible(true);
			JanelaLista.setSize(460,250);
			JanelaLista.setLocation(450, 250);	 
		 
		}		
		/////////////////remover debitos//////////////////////////////
		if(evento.getSource() == btRemoveDbt){
		  try{
			  int id = Integer.parseInt(JOptionPane.showInputDialog("ID do Usuario: "));
			  
			  contaUsuario conta = (contaUsuario)b.getUsuarios().get(id).getConta();			  
			  conta.setDebitos(0f);
			  b.getUsuarios().get(id).setConta(conta);
			  
			  JOptionPane.showMessageDialog(this, String.format("Debitos Removidos!!!")); 
		  }catch(Exception excessao0){
			 //mensagem de erro 
		  }
		  
		}
		
		if(evento.getSource() == btEmpresLivro){
		  try{
			  
			  functions.emprestimoDeLivro(b, this);
			 /* int ref = Integer.parseInt(JOptionPane.showInputDialog("Ref. Do livro: "));
			  int id;
			  int senha;
			  if(b.getLivros().get(ref).getQtd() > 0){	
				  id = Integer.parseInt(JOptionPane.showInputDialog("ID do Usuario: ")); 
				  senha = Integer.parseInt(JOptionPane.showInputDialog("Senha do Usuario: "));
				  if(b.getUsuarios().get(id).getConta().autenticar(senha)){
					contaUsuario conta = (contaUsuario)b.getUsuarios().get(id).getConta(); 
					if(conta.getEmpretimos().size() == 0){
					  conta.getEmpretimos().add(b.getLivros().get(ref));
					  b.getLivros().get(ref).setQtd(b.getLivros().get(ref).getQtd() - 1);
					  JOptionPane.showMessageDialog(this, String.format("Livro Emprestado!"));
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
						  JOptionPane.showMessageDialog(this, String.format("Livro Emprestado!"));
					  }else{
						  JOptionPane.showMessageDialog(this, String.format("Livro Ja Emprestado!")); 
					  }
					}
				  }else{
					  JOptionPane.showMessageDialog(this, String.format("Tente novamente.\ninformacoes de Usuario incompativeis!!"));
				  }
			  }	*/		  
		  }catch(Exception excessao){
			  JOptionPane.showMessageDialog(this, String.format("Tente novamente, informacoes incompativeis!!")); 
		  }	
		}
		
		if(evento.getSource() == btListarUsuario){
            JFrame JanelaLista = new JFrame("Todos os Usuarios");
			
			//adicao do painel e configuracoes gerais do JFrame
			JanelaLista.add(new listaUsuarios(b));
			JanelaLista.setVisible(true);
			JanelaLista.setSize(460,250);
			JanelaLista.setLocation(450, 250);		
		}
		
      }//fim da funcao
}
