package infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import business.model.ficha.Ficha;

public class PersistenciaDeFichas {
	
	private final String directory = "";
	private final String filename = "fichas.bin";
	
	public PersistenciaDeFichas () {
		load();
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Ficha> load(){
		/* Carrega hash map de fichas em arquivo */
		String filePath = this.directory + this.filename;
		File f = new File(filePath);
		ObjectInputStream in;
		HashMap < String, Ficha> fichas = null;
		try {
			in = new ObjectInputStream(new FileInputStream(f));
			fichas = (HashMap <String, Ficha>) in.readObject();
			in.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return fichas;
	}
	
	public void save(Map<String, Ficha> fichas){
		/* Salva hash map de fichas em arquivo */
		File f = new File(this.directory + this.filename);
		try{
			ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream(f) );
			output.writeObject(fichas);
			output.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
