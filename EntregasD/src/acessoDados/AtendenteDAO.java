package acessoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Atendente;
import conexaoDB.GerenciadorConexao;
import interfaces.Acoes;

public class AtendenteDAO implements Acoes<Atendente>{

	private Connection conn;
	
	public AtendenteDAO() {
		this.conn =  GerenciadorConexao.getConexao();
	}
	@Override
	public Atendente inserir(Atendente t) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			
			String sql = "INSERT INTO entregas.tbAtendente(registro, login,senha,nome,ramal) "
					+ "VALUES (?, ? , ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, t.getRegistro());
			stmt.setString(2, t.getLogin());
			stmt.setString(3, t.getSenha());
			stmt.setString(4, t.getNome());
			stmt.setString(5, t.getRamal());
			
			boolean erro = stmt.execute();
			
			if (!erro) {
				Statement stm = conn.createStatement();
				sql = "SELECT LAST_INSERT_ID() AS Id FROM entregas.tbAtendente";
				rs = stm.executeQuery(sql);
				
				while (rs.next()) {
					t.setId(rs.getInt("Id"));
				}
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: cliente não foi cadastrado" + e.getMessage());
		}
		finally {
			GerenciadorConexao.closeStatement(stmt);
			GerenciadorConexao.closeResultSet(rs);
			GerenciadorConexao.closeConnection(conn);
		}
		
		return t;
	}

	@Override
	public Atendente atualizar(Atendente t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Atendente> selecionarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Atendente selecionarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
