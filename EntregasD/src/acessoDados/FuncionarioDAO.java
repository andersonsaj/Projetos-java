package acessoDados;

import java.sql.Connection;
import java.util.List;

import classes.Funcionario;
import conexaoDB.GerenciadorConexao;
import interfaces.Acoes;

public class FuncionarioDAO implements Acoes<Funcionario>{
	private Connection conn ; 
	
	public FuncionarioDAO(){
		this.conn = GerenciadorConexao.getConexao();
	}
	@Override
	public Funcionario inserir(Funcionario t){
		
		GerenciadorConexao.closeConnection(conn);
		return t;
	}

	@Override
	public Funcionario atualizar(Funcionario t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> selecionarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario selecionarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
