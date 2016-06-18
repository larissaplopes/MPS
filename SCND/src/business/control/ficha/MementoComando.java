package business.control.ficha;

import business.model.ficha.Ficha;

/**
 * Utilização do padrão Memento
 */

public class MementoComando{
	
	private Comando comando;
	
	public MementoComando (Comando c) {
		comando = c;
	}

	public Comando getEstado(){
		return comando;
	}
	
	public void setEstado(Comando c){
		comando = c;
	}
	
}
