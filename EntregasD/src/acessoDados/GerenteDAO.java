package acessoDados;

import java.sql.Connection;
import java.util.List;

import classes.Gerente;
import conexaoDB.GerenciadorConexao;
import interfaces.Acoes;

public class GerenteDAO implements Acoes<Gerente>{
	private Connection conn ; 
	
	public GerenteDAO(){
		this.conn = GerenciadorConexao.getConexao();
	}
	@Override
	public Gerente inserir(Gerente t){
		
		GerenciadorConexao.closeConnection(conn);
		return t;
	}

	@Override
	public Gerente atualizar(Gerente t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gerente> selecionarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gerente selecionarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
