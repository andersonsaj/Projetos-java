package acessoDados;

import java.sql.Connection;
import java.util.List;

import classes.Categoria;
import conexaoDB.GerenciadorConexao;
import interfaces.Acoes;

public class CategoriaDAO implements Acoes<Categoria>{
	private Connection conn ; 
	
	public CategoriaDAO(){
		this.conn = GerenciadorConexao.getConexao();
	}
	@Override
	public Categoria inserir(Categoria t){
		
		GerenciadorConexao.closeConnection(conn);
		return t;
	}

	@Override
	public Categoria atualizar(Categoria t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> selecionarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria selecionarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
