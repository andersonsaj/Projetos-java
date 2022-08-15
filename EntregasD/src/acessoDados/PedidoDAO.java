package acessoDados;

import java.sql.Connection;
import java.util.List;

import classes.Pedido;
import conexaoDB.GerenciadorConexao;
import interfaces.Acoes;

public class PedidoDAO implements Acoes<Pedido>{
	private Connection conn ; 
	
	public PedidoDAO(){
		this.conn = GerenciadorConexao.getConexao();
	}
	@Override
	public Pedido inserir(Pedido t){
		
		GerenciadorConexao.closeConnection(conn);
		return t;
	}

	@Override
	public Pedido atualizar(Pedido t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> selecionarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido selecionarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
