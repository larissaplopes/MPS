package infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import business.model.user.Usuario;

public class PersistenciaDeUsuarios {
	
	private final String directory = "";
	private final String filename = "users.bin";
	
	public PersistenciaDeUsuarios () {
		load();
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Usuario> load(){
		/* Carrega hash map de usuários em arquivo */
		String filePath = this.directory + this.filename;
		File f = new File(filePath);
		ObjectInputStream in;
		HashMap < String, Usuario> users = null;
		try {
			in = new ObjectInputStream(new FileInputStream(f));
			users = (HashMap <String, Usuario>) in.readObject();
			in.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void save(Map<String, Usuario> users){
		/* Salva hash map de usuários em arquivo */
		File f = new File(this.directory + this.filename);
		try{
			ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream(f) );
			output.writeObject(users);
			output.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
