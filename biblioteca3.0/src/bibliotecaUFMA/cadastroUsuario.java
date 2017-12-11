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

public class cadastroUsuario extends JPanel implements ActionListener{
	  /**
	 * 
	 */
	  private static final long serialVersionUID = 1L;
	  private JLabel cadastro; 
	  private JLabel nome;
	  private JLabel sobrenome;
	  private JLabel cpf;	
	  private JLabel senha;
	  private JLabel id;
	  
	  private JTextField campoNome;
	  private JTextField campoSobrenome;
	  private JTextField campoCpf;
	  private JTextField campoSenha;
	  private JTextField campoId;
	  
	  private JButton btCadastro;
	  
	  private SpringLayout layout;
	  
	  private biblioteca b;
		
	  public cadastroUsuario(biblioteca x){
		this.b = x;
		this.setSize(450, 250);
		this.componentes();
		this.setLayout(layout);
	  }	
	  
	  public void componentes(){
		layout = new SpringLayout();
		cadastro = new JLabel ("Cadastro Usuario: ");
		nome = new JLabel("Nome: ");
		sobrenome = new JLabel("Sobrenome: ");
		cpf = new JLabel ("CPF: ");		
		senha = new JLabel("Senha: ");
		id = new JLabel ("ID: ");
		
		campoNome = new JTextField(20);
		campoSobrenome = new JTextField(20);
		campoCpf = new JTextField(11);		
		campoSenha = new JTextField(20);
		campoId = new JTextField(5);

		btCadastro = new JButton("Cadastrar");
		
		btCadastro.addActionListener(this);
		cadastro.setFont(new Font("Arial",0 , 18));
		
		this.add(cadastro);
		this.add(nome);
		this.add(campoNome);
		this.add(sobrenome);
		this.add(cpf);
		this.add(campoCpf);
		this.add(campoSobrenome);
		this.add(senha);
		this.add(campoSenha);
		this.add(btCadastro);
		this.add(id);
		this.add(campoId);
		
		//tip Texts
		nome.setToolTipText("Digite Ao Lado Seu Nome");
		campoNome.setToolTipText("Digite Aqui Seu Nome");
		sobrenome.setToolTipText("Digite Ao Lado Seu Sobrenome");
		campoSobrenome.setToolTipText("Digite Aqui Seu Sobrenome");	
		cpf.setToolTipText("Digite Ao Lado Seu CPF");
		campoCpf.setToolTipText("Digite Aqui Seu CPF");
		id.setToolTipText("Digite ao Lado Seu ID");
		senha.setToolTipText("Digite ao Lado Sua Senha");
		campoId.setToolTipText("Digite aqui Seu ID");
		campoSenha.setToolTipText("Digite aqui Sua Senha");
		btCadastro.setToolTipText("Informe Seus Dados, e Clique Para Se Cadastrar");
		
		layout.putConstraint(SpringLayout.WEST, cadastro, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, cadastro, 10, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, nome, 38, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, nome, 40, SpringLayout.SOUTH, cadastro);
		
		layout.putConstraint(SpringLayout.WEST, campoNome, 5, SpringLayout.EAST, nome);
		layout.putConstraint(SpringLayout.NORTH, campoNome, 40, SpringLayout.SOUTH, cadastro);
		
		layout.putConstraint(SpringLayout.WEST, sobrenome, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, sobrenome, 10, SpringLayout.SOUTH, nome);
			
		layout.putConstraint(SpringLayout.WEST, campoSobrenome, 5, SpringLayout.EAST, sobrenome);
		layout.putConstraint(SpringLayout.NORTH, campoSobrenome, 10, SpringLayout.SOUTH, nome);
		
		layout.putConstraint(SpringLayout.WEST, cpf, 50, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, cpf, 10, SpringLayout.SOUTH, sobrenome);
		
		layout.putConstraint(SpringLayout.WEST, campoCpf, 5, SpringLayout.EAST, cpf);
		layout.putConstraint(SpringLayout.NORTH, campoCpf, 10, SpringLayout.SOUTH, sobrenome);
		
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
		
	  }
	@Override
	  public void actionPerformed(ActionEvent evento) {		
		if(evento.getSource() == btCadastro){
		  try{
			  String nome = campoNome.getText();
			  String sobrenome = campoSobrenome.getText();
			  long cpf = Long.parseLong(campoCpf.getText());
			  int senha = Integer.parseInt(campoSenha.getText());
			  int id = Integer.parseInt(campoId.getText());
			
			  /*System.out.println(nome);
			  System.out.println(sobrenome);
			  System.out.println(cpf);
			  System.out.println(senha);
			  System.out.println(id);*/
			  
			  
			  contaUsuario userAccount = new contaUsuario(senha, id);
			  usuario user = new usuario(nome, sobrenome, cpf, userAccount);
			  
			  b.getUsuarios().put(id, user);
			  
			 /* System.out.println(b.getUsuarios().size());
			  for(int key : b.getUsuarios().keySet()){
				  System.out.println(b.getUsuarios().get(key).getNome());
				  System.out.println(b.getUsuarios().get(key).getSobrenome());
				  System.out.println(b.getUsuarios().get(key).getCpf());
				  System.out.println(b.getUsuarios().get(key).getConta().getId());
				  System.out.println(b.getUsuarios().get(key).getConta().getSenha());
			  }*/
			  //JOptionPane.showMessageDialog(this, String.format("ta funcionando"));
			  if(b.getUsuarios().put(id, user) != null){
				  JOptionPane.showMessageDialog(this, String.format("Usuario Cadastrado com Sucesso!!!"));			
				  campoNome.setText("");
				  campoSobrenome.setText("");
				  campoCpf.setText("");
				  campoSenha.setText(""); 
				  campoId.setText("");
			  }/*else{
				  JOptionPane.showMessageDialog(this, String.format("veio no else"));	
			  }*/
		  }catch(Exception excessao){
			  JOptionPane.showMessageDialog(this, String.format("Verifique seus dados!")); 	
		  }
	    }
	  }
}
