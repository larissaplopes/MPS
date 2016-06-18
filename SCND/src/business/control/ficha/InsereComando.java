package business.control.ficha;

import business.model.ficha.Ficha;

public class InsereComando implements Comando {
	
	private Ficha ficha;
	
	public InsereComando(Ficha f){
		ficha = f;
	}

	@Override
	public Ficha execute(FichaControl fichas) {
		fichas.insereFicha(ficha);
		return ficha;
	}

	
	
}
