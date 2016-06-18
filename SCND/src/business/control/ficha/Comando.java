package business.control.ficha;

import business.model.ficha.Ficha;

/**
 *	Utilização do padrão Command
 */

public interface Comando {
	public abstract Ficha execute(FichaControl fichas);

}
