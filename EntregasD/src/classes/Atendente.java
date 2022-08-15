package classes;

import interfaces.Autenticavel;

public class Atendente extends Funcionario implements Autenticavel{
	
	private String ramal;

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

}
