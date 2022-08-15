package classes;

import java.util.HashSet;
import java.util.Set;

public class Cliente extends Pessoa{
	private int id;
	private Set<Endereco> enderecos = new HashSet<Endereco>();;
	private String telefone;
	
	public Set<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
