package acessoDados;

import java.sql.Connection;
import java.util.List;

import classes.Endereco;
import conexaoDB.GerenciadorConexao;
import interfaces.Acoes;

public class EnderecoDAO implements Acoes<Endereco>{
	private Connection conn ; 
	
	public EnderecoDAO(){
		this.conn = GerenciadorConexao.getConexao();
	}
	@Override
	public Endereco inserir(Endereco t){
		
		GerenciadorConexao.closeConnection(conn);
		return t;
	}

	@Override
	public Endereco atualizar(Endereco t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> selecionarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco selecionarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
