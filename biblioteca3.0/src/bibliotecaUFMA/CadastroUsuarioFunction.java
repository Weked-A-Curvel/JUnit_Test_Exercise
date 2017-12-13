package bibliotecaUFMA;

public class CadastroUsuarioFunction {
	
	
	public boolean cadastro(biblioteca b,int senha, int id, String nome, String sobrenome, long cpf) {
		
		try {
			if(b != null) {
				contaUsuario userAccount = new contaUsuario(senha, id);
				if(userAccount != null) {
					usuario user = new usuario(nome, sobrenome, cpf, userAccount);
					if(user != null){
						b.getUsuarios().put(id, user);
						return true;
					} 
				}
			}
			
		}catch(Exception excessao) {}
		
		return false;
	}
}
