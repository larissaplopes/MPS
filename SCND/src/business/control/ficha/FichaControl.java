package business.control.ficha;

import infra.PersistenciaDeFichas;

import java.util.HashMap;
import java.util.LinkedList;
import business.model.*;
import business.model.ficha.Ficha;
import business.control.*;

public class FichaControl {

	HashMap < String, Ficha > fichas = new HashMap < String, Ficha > ();
	PersistenciaDeFichas persistencia = new PersistenciaDeFichas();
	
	public FichaControl(){
		this.fichas = persistencia.load();
	}
	
	public void insereFicha(Ficha f){
		this.fichas.put(f.getGestante().getCpf(), f);
	}
	
	public LinkedList < Ficha > todasFichas(){
		return (LinkedList<Ficha>) this.fichas.values();
	}
	
	public Ficha getFicha(String key){
		return this.fichas.get(key);
	}
	
	public void removerFicha(String key){
		this.fichas.remove(key);
	}
	
	public void salvarFichas(){
		persistencia.save(this.fichas);
	}
	
	public void desfazerOperacao(MementoComando memento){
		Comando c = memento.getEstado();
		c.execute(this);
		memento.setEstado(null);
	}
	
	
}
