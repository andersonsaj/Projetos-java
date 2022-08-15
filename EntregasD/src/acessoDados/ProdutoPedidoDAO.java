package acessoDados;

import java.sql.Connection;
import java.util.List;

import classes.ProdutoPedido;
import conexaoDB.GerenciadorConexao;
import interfaces.Acoes;

public class ProdutoPedidoDAO implements Acoes<ProdutoPedido>{
	private Connection conn ; 
	
	public ProdutoPedidoDAO(){
		this.conn = GerenciadorConexao.getConexao();
	}
	@Override
	public ProdutoPedido inserir(ProdutoPedido t){
		
		GerenciadorConexao.closeConnection(conn);
		return t;
	}

	@Override
	public ProdutoPedido atualizar(ProdutoPedido t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdutoPedido> selecionarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutoPedido selecionarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
