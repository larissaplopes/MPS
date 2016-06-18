package business.model.ficha;

import java.util.*;

import business.model.paciente.Gestante;
import business.model.paciente.Hospital;
import business.model.paciente.RecemNascido;

public class Ficha {
	private int numeroFicha;
	private Calendar data = Calendar.getInstance();
	private String cidade;
	private Gestante gestante;
	private LinkedList<RecemNascido> recemNascidos;
	private Hospital hospital;
	private String cpfCriador;
	enum TipoNotificacao {
		FETO, RECEMNASCIDO, OUTRASINFO, GESTANTEENXATEMA
	}
	private TipoNotificacao tipo;
	enum Classificacao {ENTRADA, ACOMPANHAMENTO, CONFIRMADO, DESCARTADO}
	private Classificacao classificacao;
	
	public Ficha(int numeroFicha,
			String cidade, Gestante gestante, LinkedList < RecemNascido > recemNascidos, Hospital hospital, String cpf) {
		super();
		this.data.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
		this.numeroFicha = numeroFicha;
		this.cidade = cidade;
		this.gestante = gestante;
		this.hospital = hospital;
		this.cpfCriador = cpf;
		this.recemNascidos = recemNascidos;
	}
	
	public void adicionarFilho(RecemNascido r){
		this.recemNascidos.add(r);
	}
	
	public LinkedList<RecemNascido> getRecemNascidos(){
		return this.recemNascidos;
	}
	
	public TipoNotificacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoNotificacao tipo) {
		this.tipo = tipo;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}



	public int getNumeroFicha() {
		return numeroFicha;
	}
	public void setNumeroFicha(int numeroFicha) {
		this.numeroFicha = numeroFicha;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public String getCpfCriador() {
		return cpfCriador;
	}
	public void setCpfCriador(String cpfCriador) {
		this.cpfCriador = cpfCriador;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Gestante getGestante() {
		return gestante;
	}
	
	public void setPaciente(Gestante paciente) {
		this.gestante = paciente;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
}
