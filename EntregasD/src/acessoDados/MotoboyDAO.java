package acessoDados;

import java.sql.Connection;
import java.util.List;

import classes.Motoboy;
import conexaoDB.GerenciadorConexao;
import interfaces.Acoes;

public class MotoboyDAO implements Acoes<Motoboy>{
	private Connection conn ; 
	
	public MotoboyDAO(){
		this.conn = GerenciadorConexao.getConexao();
	}
	@Override
	public Motoboy inserir(Motoboy t){
		
		GerenciadorConexao.closeConnection(conn);
		return t;
	}

	@Override
	public Motoboy atualizar(Motoboy t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Motoboy> selecionarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Motoboy selecionarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
