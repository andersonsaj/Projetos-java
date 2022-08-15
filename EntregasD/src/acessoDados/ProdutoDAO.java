package acessoDados;

import java.sql.Connection;
import java.util.List;

import classes.Produto;
import conexaoDB.GerenciadorConexao;
import interfaces.Acoes;

public class ProdutoDAO implements Acoes<Produto>{
	private Connection conn ; 
	
	public ProdutoDAO(){
		this.conn = GerenciadorConexao.getConexao();
	}
	@Override
	public Produto inserir(Produto t){
		
		GerenciadorConexao.closeConnection(conn);
		return t;
	}

	@Override
	public Produto atualizar(Produto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> selecionarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto selecionarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
