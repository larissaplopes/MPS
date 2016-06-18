package business.model.paciente;

import business.model.paciente.RecemNascido.Deteccao;
import business.model.paciente.RecemNascido.Exant;

/** ESTA CLASSE IMPLEMENTA O PADRÃO FACTORY PARA GERAR
 *	PACIENTES DO TIPO GESTANTE OU RECÉM-NASCIDO
 *
 *  TAMBÉM É IMPLEMENTADO O PADRÃO SINGLETON, UMA VEZ
 *  QUE SÓ EXISTIRÁ UM OBJETO DESTA CLASSE NO PROGRAMA
 **/

public class PacienteFactory {
	
	private static PacienteFactory pacFac = new PacienteFactory();
	
	public PacienteFactory getInstance(){
		return pacFac;
	}
	
	public Gestante gestante(String nome, String cpf, int ano, int mes, int dia, char sexo, String endereco, String bairro, int numero,
			String cep, String estado, String telefone){
		return new Gestante(nome, cpf, ano, mes, dia, sexo, endereco, bairro, numero, cep, estado, telefone);
	}
	
	public RecemNascido recemNascido(String nome, int ano, int mes, int dia, char sexo, int semanasGestacao, int comprimento, 
			double peso, double perimCefalico, RecemNascido.DeteccaoMicrocefalia detec, Exant exant){
		return new RecemNascido(nome, ano, mes, dia, sexo, semanasGestacao,	comprimento, peso, perimCefalico, detec, exant);		
	}

}
