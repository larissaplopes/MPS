package business.control.ficha;

import business.model.ficha.Ficha;

public class RemoveComando implements Comando {
	
	private String cpf;
	
	public RemoveComando(String cpf){
		this.cpf = cpf;
	}

	@Override
	public Ficha execute(FichaControl fichas) {
		Ficha temp = fichas.getFicha(cpf);
		fichas.removerFicha(cpf);
		return temp;
	}

	
	
}
