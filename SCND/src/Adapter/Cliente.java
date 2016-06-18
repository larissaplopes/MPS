package Adapter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import business.model.paciente.*;

public class Cliente {
	public Gestante CadastroGestanteSUS(String numCartao){
		Gestante gestante = null;
		try {
			Socket s = new Socket("127.0.0.1", 4444);
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			out.writeUTF(numCartao);
			gestante = (Gestante)in.readObject();
			System.out.println(in.readUTF());
			in.close();
			out.close();
			s.close();
			
			return gestante;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Nao foi possivel fazer a comunicacao");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro no recebimento dos dados.");
		}
		return gestante;
		
		
	}
}
