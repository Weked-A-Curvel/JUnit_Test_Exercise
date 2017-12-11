package bibliotecaUFMA;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class login extends JPanel implements ActionListener{
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  private JLabel                       login;
  private JLabel                       id;
  private JLabel                       senha;
  private JTextField                   campoId;
  private JTextField                   campoSenha;
  private JButton                      btEntrar;
  private JButton                      btCadastrar;
  private SpringLayout                 layout;
  private biblioteca                   b;
  
  //metodo construtor
  public login(biblioteca x){
	this.b = x;
	this.setSize(500,500);
	this.componentes();
	this.setLayout(layout);
  }
  
  public void componentes(){
	layout = new SpringLayout();  
	login = new JLabel("LOGIN: ");
	id = new JLabel("ID: ");
	senha = new JLabel("Senha: ");
	campoId = new JTextField(20);
	campoSenha = new JTextField(20);
	
	
	btEntrar = new JButton("ENTRAR");
	btEntrar.addActionListener(this);
	btCadastrar = new JButton("CADASTRE-SE");
	btCadastrar.addActionListener(this);
	
	login.setFont(new Font("Arial",0 , 18));
	
	this.add(login);
	this.add(id);
	this.add(campoId);
	this.add(senha);
	this.add(campoSenha);
	this.add(btEntrar);
	this.add(btCadastrar);
	
	//tipTexts
	id.setToolTipText("Digite ao Lado Seu ID");
	senha.setToolTipText("Digite ao Lado Sua Senha");
	campoId.setToolTipText("Digite aqui Seu ID");
	campoSenha.setToolTipText("Digite aqui Sua Senha");
	btEntrar.setToolTipText("Informe seus Dados e Clique Aqui para Entrar!");
	btCadastrar.setToolTipText("Funcionario, Clique Aqui Para Se Cadastrar");
	
	//login
	layout.putConstraint(SpringLayout.WEST, login, 50, SpringLayout.WEST, this);
	layout.putConstraint(SpringLayout.NORTH, login, 150, SpringLayout.NORTH, this);
	
	//id
	layout.putConstraint(SpringLayout.WEST, id, 30, SpringLayout.WEST, this);
	layout.putConstraint(SpringLayout.NORTH, id, 40, SpringLayout.NORTH, login);
	
	layout.putConstraint(SpringLayout.WEST, campoId, 5, SpringLayout.EAST, id);
	layout.putConstraint(SpringLayout.NORTH, campoId, 40, SpringLayout.NORTH, login);
	
	layout.putConstraint(SpringLayout.WEST, senha, 5, SpringLayout.WEST, this);
	layout.putConstraint(SpringLayout.NORTH, senha, 10, SpringLayout.SOUTH, id);
	
	layout.putConstraint(SpringLayout.WEST, campoSenha, 5, SpringLayout.EAST, senha);
	layout.putConstraint(SpringLayout.NORTH, campoSenha, 10, SpringLayout.SOUTH, campoId);
	
	layout.putConstraint(SpringLayout.EAST, btEntrar, 0, SpringLayout.EAST, campoSenha);
	layout.putConstraint(SpringLayout.NORTH, btEntrar, 10, SpringLayout.SOUTH, campoSenha);
	
	layout.putConstraint(SpringLayout.EAST, btCadastrar, -5, SpringLayout.EAST, this);
	layout.putConstraint(SpringLayout.NORTH, btCadastrar, -30, SpringLayout.SOUTH, this);
	
  }

@Override
  public void actionPerformed(ActionEvent evento) {
    
	//JOptionPane.showMessageDialog( this, String.format("Botao Logar"));	
  
	/*int id;
    int senha;
  
    id = Integer.parseInt(this.campoId.getText());
    senha = Integer.parseInt(this.campoSenha.getText());*/
	if(evento.getSource() == btEntrar){
		try{
			int id = Integer.parseInt(this.campoId.getText());
		    int senha = Integer.parseInt(this.campoSenha.getText());
		    
			if(b.getFuncionarios().get(id).getConta().autenticar(senha)){
				aplicativo.telaPrincipal.remove(aplicativo.painel);
				aplicativo.painel = new FuncionarioPanel(b);
				aplicativo.telaPrincipal.add(aplicativo.painel);
				aplicativo.telaPrincipal.repaint();
				aplicativo.telaPrincipal.setVisible(true);	
			}else{
				JOptionPane.showMessageDialog(this, String.format("Informacoes Inconpativeis!\nPossui Cadastro? \nCadastre-se Sr. Funcionario"));
			}
		}catch(Exception excessao){
			JOptionPane.showMessageDialog(this, String.format("Tente novamente, informacoes incompativeis!!"));
		} 	
	}
	
	if(evento.getSource() == btCadastrar){
		aplicativo.telaPrincipal.remove(aplicativo.painel);
		aplicativo.painel = new cadastroFuncionario(b);
		aplicativo.telaPrincipal.add(aplicativo.painel);
		aplicativo.telaPrincipal.repaint();
		aplicativo.telaPrincipal.setVisible(true);	
	}

  
  }
  
}
