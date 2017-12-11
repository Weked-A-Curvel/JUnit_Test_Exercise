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

public class cadastroFuncionario extends JPanel implements ActionListener{
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  private JLabel cadastro; 
  private JLabel nome;
  private JLabel sobrenome;
  private JLabel cpf;
  private JLabel id;
  private JLabel matricula;
  private JLabel senha;
  private JTextField campoNome;
  private JTextField campoSobrenome;
  private JTextField campoCpf;
  private JTextField campoMatricula;
  private JTextField campoId;
  private JTextField campoSenha;
  private JButton btCadastro;
  private JButton btVoltar;
  private SpringLayout layout;
  private biblioteca b;
	
  public cadastroFuncionario(biblioteca x){
	this.b = x;
	this.setSize(500, 500);
	this.componentes();
	this.setLayout(layout);
  }	
  
  public void componentes(){
	layout = new SpringLayout();
	cadastro = new JLabel ("Cadastro Funcionario: ");
	nome = new JLabel("Nome: ");
	sobrenome = new JLabel("Sobrenome: ");
	cpf = new JLabel ("CPF: ");
	id = new JLabel ("ID: ");
	matricula = new JLabel("Mat.: ");
	senha = new JLabel("Senha: ");
	campoNome = new JTextField(20);
	campoSobrenome = new JTextField(20);
	campoCpf = new JTextField(11);
	campoMatricula = new JTextField(5);
	campoSenha = new JTextField(20);
	btCadastro = new JButton("Cadastrar");
	btVoltar = new JButton("<<Voltar");
	campoId = new JTextField(5);
	
	
	btCadastro.addActionListener(this);
	btVoltar.addActionListener(this);
	cadastro.setFont(new Font("Arial",0 , 18));
	
	this.add(cadastro);
	this.add(nome);
	this.add(campoNome);
	this.add(sobrenome);
	this.add(cpf);
	this.add(campoCpf);
	this.add(campoSobrenome);
	this.add(matricula);
	this.add(campoMatricula);
	this.add(senha);
	this.add(campoSenha);
	this.add(btCadastro);
	this.add(btVoltar);
	this.add(id);
	this.add(campoId);
	
	//tipsTexts
	nome.setToolTipText("Digite Ao Lado Seu Nome");
	campoNome.setToolTipText("Digite Aqui Seu Nome");
	sobrenome.setToolTipText("Digite Ao Lado Seu Sobrenome");
	campoSobrenome.setToolTipText("Digite Aqui Seu Sobrenome");	
	cpf.setToolTipText("Digite Ao Lado Seu CPF");
	campoCpf.setToolTipText("Digite Aqui Seu CPF");
	matricula.setToolTipText("Digite Ao Lado Sua Matricula");
	campoMatricula.setToolTipText("Digite Aqui Sua Matricula");	
	id.setToolTipText("Digite ao Lado Seu ID");
	senha.setToolTipText("Digite ao Lado Sua Senha");
	campoId.setToolTipText("Digite aqui Seu ID");
	campoSenha.setToolTipText("Digite aqui Sua Senha");
	btCadastro.setToolTipText("Informe Seus Dados, e Clique Para Se Cadastrar");
	btVoltar.setToolTipText("Volta Para a Tela De Login");
	
	
	layout.putConstraint(SpringLayout.WEST, cadastro, 5, SpringLayout.WEST, this);
	layout.putConstraint(SpringLayout.NORTH, cadastro, 50, SpringLayout.NORTH, this);
	
	layout.putConstraint(SpringLayout.WEST, nome, 38, SpringLayout.WEST, this);
	layout.putConstraint(SpringLayout.NORTH, nome, 60, SpringLayout.SOUTH, cadastro);
	
	layout.putConstraint(SpringLayout.WEST, campoNome, 5, SpringLayout.EAST, nome);
	layout.putConstraint(SpringLayout.NORTH, campoNome, 60, SpringLayout.SOUTH, cadastro);
	
	layout.putConstraint(SpringLayout.WEST, sobrenome, 5, SpringLayout.WEST, this);
	layout.putConstraint(SpringLayout.NORTH, sobrenome, 10, SpringLayout.SOUTH, nome);
		
	layout.putConstraint(SpringLayout.WEST, campoSobrenome, 5, SpringLayout.EAST, sobrenome);
	layout.putConstraint(SpringLayout.NORTH, campoSobrenome, 10, SpringLayout.SOUTH, nome);
	
	layout.putConstraint(SpringLayout.WEST, cpf, 50, SpringLayout.WEST, this);
	layout.putConstraint(SpringLayout.NORTH, cpf, 10, SpringLayout.SOUTH, sobrenome);
	
	layout.putConstraint(SpringLayout.WEST, campoCpf, 5, SpringLayout.EAST, cpf);
	layout.putConstraint(SpringLayout.NORTH, campoCpf, 10, SpringLayout.SOUTH, sobrenome);
	
	layout.putConstraint(SpringLayout.WEST, matricula, 5, SpringLayout.EAST, campoCpf);
	layout.putConstraint(SpringLayout.NORTH, matricula, 10, SpringLayout.SOUTH, sobrenome);
	
	layout.putConstraint(SpringLayout.WEST, campoMatricula, 5, SpringLayout.EAST, matricula);
	layout.putConstraint(SpringLayout.NORTH, campoMatricula, 10, SpringLayout.SOUTH, sobrenome);
	
	layout.putConstraint(SpringLayout.WEST, senha, 35, SpringLayout.WEST, this);
	layout.putConstraint(SpringLayout.NORTH, senha, 10, SpringLayout.SOUTH, cpf);
	
	layout.putConstraint(SpringLayout.WEST, campoSenha, 5, SpringLayout.EAST, senha);
	layout.putConstraint(SpringLayout.NORTH, campoSenha, 10, SpringLayout.SOUTH, cpf);	

	layout.putConstraint(SpringLayout.WEST, id, 60, SpringLayout.WEST, this);
	layout.putConstraint(SpringLayout.NORTH, id, 10, SpringLayout.SOUTH, senha);
	
	layout.putConstraint(SpringLayout.WEST, campoId, 5, SpringLayout.EAST, id);
	layout.putConstraint(SpringLayout.NORTH, campoId, 10, SpringLayout.SOUTH, senha);
	
	layout.putConstraint(SpringLayout.EAST, btCadastro, 0, SpringLayout.EAST, campoSenha);
	layout.putConstraint(SpringLayout.NORTH, btCadastro, 10, SpringLayout.SOUTH, campoId);
	
	layout.putConstraint(SpringLayout.EAST, btVoltar, -10, SpringLayout.EAST, this);
	layout.putConstraint(SpringLayout.SOUTH, btVoltar, -10, SpringLayout.SOUTH, this);
  }
@Override
  public void actionPerformed(ActionEvent evento) {
	if(evento.getSource() == btCadastro){
		try{
			String nome = campoNome.getText();
			String sobrenome = campoSobrenome.getText();
			long cpf = Long.parseLong(campoCpf.getText());
			int senha = Integer.parseInt(campoSenha.getText());
			int matricula = Integer.parseInt(campoMatricula.getText());
			int id = Integer.parseInt(campoId.getText());
			
			//if(b.getFuncionarios().get(id) != null){
			
			  //JOptionPane.showMessageDialog(this, String.format("ID já em Uso!\nEscolha outro e Tente Novamente"));	
			
			//}else{
			
			  contaFuncionario funcAccount = new contaFuncionario(senha, id);
			  funcionario user = new funcionario(nome, sobrenome, cpf, funcAccount, matricula);		
			
			  if(b.getFuncionarios().put(id, user) != null){
				//JOptionPane.showMessageDialog(this, String.format("ta funcionando"));			
				campoNome.setText("");
				campoSobrenome.setText("");
				campoCpf.setText("");
				campoSenha.setText(""); 
				campoMatricula.setText("");
				campoId.setText("");
				JOptionPane.showMessageDialog(this, String.format("Cadastro Realizado com Sucesso\nSeu ID é: " + id));
				aplicativo.telaPrincipal.remove(aplicativo.painel);
				aplicativo.painel = new login(b);
				aplicativo.telaPrincipal.add(aplicativo.painel);
				aplicativo.telaPrincipal.repaint();
				aplicativo.telaPrincipal.setVisible(true);
			  }
			
		    //}
		}catch(Exception excessao){
			JOptionPane.showMessageDialog(this, String.format("Verifique seus dados!")); 	
		}	
	}////////fim da acao
     
	if(evento.getSource() == btVoltar){
		aplicativo.telaPrincipal.remove(aplicativo.painel);
		aplicativo.painel = new login(b);
		aplicativo.telaPrincipal.add(aplicativo.painel);
		aplicativo.telaPrincipal.repaint();
		aplicativo.telaPrincipal.setVisible(true);	
	}
  }
}///fim da classe
