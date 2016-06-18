package SUS;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import business.model.*;
import business.model.paciente.Gestante;

public class Servidor {
	   public static void main(String[] args) throws IOException {
		      // TODO code application logic here
		      ServerSocket s = new ServerSocket(4444);
		      Socket ns = s.accept();
		      ObjectInputStream in = new ObjectInputStream(ns.getInputStream());
		      ObjectOutputStream out = new ObjectOutputStream(ns.getOutputStream());
		      
		      out.writeObject(new Gestante());
		      out.writeUTF("Dados enviados");
		      
		      in.close();
		      out.close();
		      ns.close();
		      s.close();
		   }
}
