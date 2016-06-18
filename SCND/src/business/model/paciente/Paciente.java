package business.model.paciente;

import java.util.*;

public abstract class Paciente {
	private String nome;
	private Calendar dataNasc = Calendar.getInstance();
	private char sexo;
	
	public Paciente(String nome, int ano, int mes, int dia, char sexo) {
		this.nome = nome;
		this.dataNasc.set(ano, mes, dia);
		this.sexo = sexo;
	}	
	

	public Paciente() {
		this("nome", 1999, 01, 01, 'u');
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	/** ESTE MÉTODO UTILIZA O PADRÃO METHOD TEMPLATE DA SEGUINTE FORMA:
	 * TODA MÉTODOS CONCRETOS GET SERÃO USADOS PARA PEGAR TODOS OS ATRIBUTOS DO OBJETO
	 * POREM O MÉTODO ABSTRATO dadosEspecificos IRÁ DEPENDER SE O OBJETO PACIENTE SE TRATA
	 * DE UM RECEMNASCIDO OU GESTANTE
	 **/
	public abstract HashMap<String, Object> dadosEspecificos (); // Pode ser CPF ou Certidão de Nascimento
	
	public HashMap<String, Object> pegarTodosDados(){
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("nome", getNome());
		dados.put("sexo", getSexo());
		dados.put("nascimento", getDataNasc());
		dados.putAll(dadosEspecificos());
		return dados;
	}
	
	public abstract String getID();

}
