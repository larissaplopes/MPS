package business.model.paciente;

import java.util.HashMap;


public class Gestante extends Paciente{
	private String endereco,
		   		   bairro,
		   		   cep,
		   		   estado,
		   		   telefone,
				   cpf;
	private int numero; 
	
	public Gestante(String nome, String cpf, int ano, int mes, int dia, char sexo, String endereco, String bairro, int numero,
			String cep, String estado, String telefone) {
		super(nome, ano, mes, dia, sexo);
		this.endereco = endereco;
		this.bairro = bairro;
		this.cep = cep;
		this.estado = estado;
		this.telefone = telefone;
		this.numero = numero;
		this.cpf = cpf;
	}
		
	public Gestante(){
		this("nome", "cpf", 1990, 1, 1, 'n', "endereco", "bairro", 5, "cep", "estado", "telefone");

	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public HashMap<String, Object> dadosEspecificos() {
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("endereco", getEndereco());
		dados.put("bairro", getBairro());
		dados.put("cep", getCep());
		dados.put("estado", getEstado());
		dados.put("telefone", getTelefone());
		dados.put("cpf", getCpf());
		dados.put("numero", getNumero());
		return dados;
	}

	@Override
	public String getID() {
		return cpf;
	}

}
