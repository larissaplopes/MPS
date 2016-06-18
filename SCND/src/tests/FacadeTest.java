package tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;


import tests.FichaException;
import business.control.ficha.FichaFacade;
import tests.HospitalException;

public class FacadeTest {
	private FichaFacade fichaFacade = new FichaFacade();
	@Rule
	public ExpectedException expEx = ExpectedException.none();
	
	@Test
	public void testCadastroSemHospital() throws business.control.ficha.FichaException {
		expEx.expect(FichaException.class);
	    expEx.expectMessage("Hospital ainda não cadastrado!");
		fichaFacade.cadastrarFicha(111111, "João Pessoa", "012.120.201.10");
	}
	
	@Test
	public void testCadastroSemGestante() throws business.control.pacientes.HospitalException, business.control.ficha.FichaException {
		expEx.expect(FichaException.class);
	    expEx.expectMessage("Gestante ainda não cadastrada!");
	    fichaFacade.cadastrarHospital("Hospital 1", "Campina Grande", "PB");
		fichaFacade.cadastrarFicha(1111, "João Pessoa", "111.111.111-11");
	}
	
	@Test
	public void testHospitalSemNome() throws business.control.pacientes.HospitalException, business.control.ficha.FichaException {
		expEx.expect(HospitalException.class);
	    expEx.expectMessage("Nome do hospital não pode ser vazio!");
	    fichaFacade.cadastrarHospital("", "Campina Grande", "PB");
		fichaFacade.cadastrarFicha(1111, "João Pessoa", "111.111.111-11");
	}
	
	@Test
	public void testCadastroSemRecemNascido() throws business.control.pacientes.HospitalException, business.control.ficha.FichaException {
		expEx.expect(FichaException.class);
	    expEx.expectMessage("Não foram inseridos recém-nascidos!");
	    fichaFacade.cadastrarHospital("Hospital 1", "Campina Grande", "PB");
	    fichaFacade.cadastrarGestante("Maria", "111.111.111-11", 1990, 12, 11, 'M', "teste", "teste", 1, "teste", "teste", "teste");
	    fichaFacade.cadastrarFicha(1111, "João Pessoa", "111.111.111-11");
	}

}
