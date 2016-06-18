package business.control.ficha;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

import Adapter.AdaptadorSUS;
import business.control.pacientes.HospitalException;
import business.model.ficha.Ficha;
import business.model.paciente.*;

public class FichaFacade {
	
	/**
	 * Esta classe utiliza o padrão Façade para executar comandos e desfazer operação (padrão Memento)
	 */
	
	private FichaControl fichaControl = new FichaControl();
	private Gestante gestante;
	private LinkedList < RecemNascido > recemNascidos = new LinkedList<RecemNascido>();
	private Hospital hospital;
	
	public FichaFacade(){}
	
	public void cadastrarFicha(int numeroFicha,
			String cidade, String cpf) throws FichaException {
		if(hospital == null)
			throw new FichaException("Hospital ainda não cadastrado!");
		if(gestante == null)
			throw new FichaException("Gestante ainda não cadastrada!");
		if(recemNascidos.size() == 0)
			throw new FichaException("Não foram inseridos recém-nascidos!");
		if(hospital != null && recemNascidos.size() > 0 && gestante != null){
			Ficha f = new Ficha(numeroFicha, cidade, this.gestante, this.recemNascidos, this.hospital, cpf);
			this.fichaControl.insereFicha(f);
			this.hospital = null;
			this.gestante = null;
			this.recemNascidos.clear();
		}
		
	}
	
	public void cadastrarHospital(String nome, String cidade, String estado) throws HospitalException{
		if(nome == "")
			throw new HospitalException("Nome do hospital não pode ser vazio!");
		if(cidade == "")
			throw new HospitalException("Não da cidade não pode ser vazio!");
		if(estado == "")
			throw new HospitalException("Não do estado não pode ser vazio!");
		this.hospital = new Hospital(nome, cidade, estado);
	}
	
	public void cadastrarRecemNascido(String nome, int ano, int mes, int dia, char sexo, int semanasGestacao,
			int comprimento, double peso, double perimCefalico, RecemNascido.DeteccaoMicrocefalia detec, 
			RecemNascido.Exant exant){
		RecemNascido r = new RecemNascido(nome, ano, mes, dia, sexo, semanasGestacao, comprimento, peso, perimCefalico, detec, exant);
		this.recemNascidos.add(r);
	}
	
	public void cadastrarGestante(String nome, String cpf, int ano, int mes, int dia, char sexo, String endereco, String bairro, int numero,
			String cep, String estado, String telefone){
		this.gestante = new Gestante(nome, cpf, ano, mes, dia, sexo, endereco, bairro, numero, cep, estado, telefone);
	}
	
	public void CadastroGestanteSUS(String numCartao){
		try {
			Gestante gestante;
			Socket s = new Socket("127.0.0.1", 4444);
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			out.writeUTF(numCartao);
			gestante = (Gestante)in.readObject();
			System.out.println(in.readUTF());
			in.close();
			out.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Nao foi possivel fazer a comunicacao");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro no recebimento dos dados.");
		}
		
	}
	
	public void novoCadGestanteSUS(String numCartao){
		AdaptadorSUS adaptador = new AdaptadorSUS();
		
		this.gestante = adaptador.conexao();
	}

}
