package business.control.user;

import infra.PersistenciaDeUsuarios;

import java.util.Map;

import exceptions.UserException;

import business.model.user.Usuario;

public class UsuarioControl {
	private Map <String, Usuario> users;
	private PersistenciaDeUsuarios userFile = new PersistenciaDeUsuarios();

	public UsuarioControl() {
		/* Carrega os usuários salvos ao iniciar */
		this.users = this.userFile.load();
	}
	
	public void addUser(Usuario u) throws UserException{
		/* Lançamento das exceções */
		if(u.getNome() == "")
			throw new UserException("Nome vazio");
		if(u.getNome().length() > 20)
			throw new UserException("Nome acima de 20 caracteres");
		if(u.getNome().matches(".*\\d.*"))
			throw new UserException("Nome contém números");
		if(u.getSenha().length() > 12)
			throw new UserException("Senha com mais de 12 caracteres");
		if(u.getSenha().length() < 8)
			throw new UserException("Senha com menos de 8 caracteres");
		this.users.put(u.getNome(), u);
		
		userFile.save(this.users);
	}
	
	public void removeUser(String l) throws UserException{
		Usuario deletado = this.users.get(l);
		if(deletado == null)
			throw new UserException("Usuário inexistente");
		this.users.remove(l);
	}
	
	public Map<String, Usuario> getUsers(){
		return this.users;
	}
	
	public boolean userExists(String name, String pass){
		if(users.containsKey(name)){
			if(users.get(name).getSenha().equals(pass))
				return true;
			else 
				return false;
		}
		else
			return false;
	}
}
