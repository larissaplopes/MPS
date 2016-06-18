package business.model.user;

public class UsuarioAdministrador extends Usuario {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public UsuarioAdministrador(String n, String s, String c) {
		super(n, s, c);
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return ("Nome " + super.getNome() + "\nSenha: " + super.getSenha() + "\nTipo: " + this.getClass().getSimpleName());
	}

}
