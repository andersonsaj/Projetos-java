package entities;

import java.util.List;
import java.util.function.Predicate;

public class Funcionarios {
	
	private String nome,email;
	private Double salario;
	
	public Funcionarios() {
	}
	public Funcionarios(String nome, String email, Double salario) {
		this.nome = nome;
		this.email = email;
		this.salario = salario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public double somaSalario(List<Funcionarios> list, Predicate<Funcionarios> fun) {
		double sum = 0.0;
		for(Funcionarios f : list) {
			if(fun.test(f)) {
				sum+=f.getSalario();
			}
		}
		return sum;
	}
}
