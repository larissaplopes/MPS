package Adapter;

import javax.swing.JOptionPane;

import business.model.paciente.Gestante;;

public class AdaptadorSUS extends Cliente implements Acao{
	public String obterDados(){
		return JOptionPane.showInputDialog("Informe seu cartao SUS");
	}
	public Gestante conexao(){
		Cliente c = new Cliente();
		return c.CadastroGestanteSUS(obterDados());
	}
}
