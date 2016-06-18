package business.model.paciente;


public class Hospital {
	private String nome,
				   cidade, 
			       estado;
	
	public Hospital(String nome, String cidade, String estado){
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Hospital(){
		this("nome", "cidade", "estado");
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setNome(String n) {
		nome = n;
	}
	
	public void setCidade(String c) {
		cidade = c;
	}

	public void setEstado(String e) {
		estado = e;
	}
}
