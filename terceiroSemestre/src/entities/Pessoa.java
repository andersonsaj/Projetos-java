package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private String nome;
	private String cpf;
	private Date nascimento;
	private String endereço;
	private String sexo;
	private String rg;
	private String email;
	private String telefone;
	private String estadoCivil;
	private String status;
	
	public Pessoa () {
	}
	
	public Pessoa(String nome, String cpf, Date nascimento, String endereço, String sexo, String rg, String email,
			String telefone, String estadoCivil, String status) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.endereço = endereço;
		this.sexo = sexo;
		this.rg = rg;
		this.email = email;
		this.telefone = telefone;
		this.estadoCivil = estadoCivil;
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", nascimento=" + sdf.format(nascimento) + ", endereço=" + endereço
				+ ", sexo=" + sexo + ", rg=" + rg + ", email=" + email + ", telefone=" + telefone + ", estadoCivil="
				+ estadoCivil + ", status=" + status + "]";
	}



	
}
