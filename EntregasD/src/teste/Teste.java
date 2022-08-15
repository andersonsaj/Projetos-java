package teste;

import java.sql.Connection;
import java.sql.SQLException;

import classes.Atendente;
import classes.Funcionario;
import classes.Gerente;
import classes.Motoboy;
import conexaoDB.GerenciadorConexao;

public class Teste {

	public static void main(String[] args) {
		
		Atendente atendente = new Atendente();
		Motoboy motoboy = new Motoboy();
		Gerente gerente = new Gerente();
	
	}
	
	public static void autenticar(Funcionario funcionario) throws SQLException {
		
		Connection c = GerenciadorConexao.getConexao();
		System.out.println("Autenticou");
	}
}
