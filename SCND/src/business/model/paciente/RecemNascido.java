package business.model.paciente;

import java.util.HashMap;


public class RecemNascido extends Paciente{
	private int semanasGestacao,
				comprimento,
				num_certidao;
	private double peso,
				   perimCefalico;
	public enum DeteccaoMicrocefalia {POSPARTO, INTRAUTERINO, IGNORADO, NAODETECTADO};
	DeteccaoMicrocefalia detec;
	public enum Exant {SIM, NAO, NAOSABE};
	private Exant exant;
	enum Deteccao {POSPARTO, INTRAUTERINO, IGNORADO, NAODETECTADO};
	Deteccao detecao;
	public RecemNascido(String nome, int ano, int mes, int dia, char sexo, int semanasGestacao,
			int comprimento, double peso, double perimCefalico, DeteccaoMicrocefalia detec, 
			Exant exant) {
		super(nome, ano, mes, dia, sexo);
		this.semanasGestacao = semanasGestacao;
		this.comprimento = comprimento;
		this.peso = peso;
		this.perimCefalico = perimCefalico;
		this.detec = detec;
		this.exant = exant;
	}
	
	public Deteccao getDetecao() {
		return detecao;
	}

	public void setDetecao(Deteccao detecao) {
		this.detecao = detecao;
	}



	public RecemNascido(){
		this("nome", 1990, 1, 1, 'n', 56, 30, 3.0, 33.0, DeteccaoMicrocefalia.NAODETECTADO, Exant.NAO);
	}

	public int getNum_certidao() {
		return num_certidao;
	}

	public void setNum_certidao(int num_certidao) {
		this.num_certidao = num_certidao;
	}

	public int getSemanasGestacao() {
		return semanasGestacao;
	}

	public void setSemanasGestacao(int semanasGestacao) {
		this.semanasGestacao = semanasGestacao;
	}

	public int getComprimento() {
		return comprimento;
	}

	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPerimCefalico() {
		return perimCefalico;
	}

	public void setPerimCefalico(double perimCefalico) {
		this.perimCefalico = perimCefalico;
	}

	public DeteccaoMicrocefalia getDetec() {
		return detec;
	}

	public void setDetec(DeteccaoMicrocefalia detec) {
		this.detec = detec;
	}

	public Exant getExant() {
		return exant;
	}

	public void setExant(Exant exant) {
		this.exant = exant;
	}

	@Override
	public HashMap<String, Object> dadosEspecificos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
}
