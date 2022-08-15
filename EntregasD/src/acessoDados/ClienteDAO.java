package acessoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Cliente;
import conexaoDB.GerenciadorConexao;
import interfaces.Acoes;

public class ClienteDAO implements Acoes<Cliente>{
	private Connection conn ; 
	
	public ClienteDAO(){
		this.conn = GerenciadorConexao.getConexao();
	}
	@Override
	public Cliente inserir(Cliente t){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO entregas.tbCliente(nome,telefone) VALUES (?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, t.getNome());
			stmt.setString(2, t.getTelefone());
			
			boolean erro = stmt.execute();
			
			if (!erro) {
				Statement stm = conn.createStatement();
				sql = "SELECT LAST_INSERT_ID() AS Id FROM entregas.tbCliente";
				rs = stm.executeQuery(sql);
				
				while (rs.next()) {
					t.setId(rs.getInt("Id"));
				}
			}
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"Error: "+ e.getMessage());
		}
		finally {
			GerenciadorConexao.closeStatement(stmt);
			GerenciadorConexao.closeResultSet(rs);
			GerenciadorConexao.closeConnection(conn);
		}
		
		return t;
	}

	@Override
	public Cliente atualizar(Cliente t){
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE entregas.tbCliente set "
					+ "nome = ?, telefone = ? where id = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, t.getNome());
			stmt.setString(2, t.getTelefone());
			stmt.setInt(3, t.getId());
			
			stmt.execute();
			JOptionPane.showMessageDialog(null, "Dados do Cliente atualizado com Sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro:"+ e.getMessage());
		}finally {
			GerenciadorConexao.closeConnection(conn);
			GerenciadorConexao.closeStatement(stmt);
		}
		return null;
	}

	@Override
	public List<Cliente> selecionarTodos(){
		
		List<Cliente> clientes = new ArrayList<>();
		Statement stm =null;
		ResultSet rs = null;
		try {
			 stm = conn.createStatement();
			
			String sql = "select id, nome, telefone from entregas.tbCliente";
			
			rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
				
				clientes.add(cliente);
			}
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}finally {
			GerenciadorConexao.closeStatement(stm);
			GerenciadorConexao.closeResultSet(rs);
			GerenciadorConexao.closeConnection(conn);
		}
		
		return clientes;
	}

	@SuppressWarnings("null")
	@Override
	public Cliente selecionarPorId(int id){
		Cliente cliente = new Cliente();
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			//con.setAutoCommit(false);
			
			String sql = "select id, nome, telefone from entregas.tbCliente where id = ?";
			
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, String.valueOf(id));
			
			result = stmt.executeQuery();
			
			while (result.next()) {
				cliente.setId(result.getInt("id"));
				cliente.setNome(result.getString("nome"));
				cliente.setTelefone(result.getString("telefone"));
			}
			
			//con.commit();

		}catch(SQLException e) {
			//con.rollback();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}finally {
			GerenciadorConexao.closeStatement(stmt);
			GerenciadorConexao.closeResultSet(result);
			GerenciadorConexao.closeConnection(conn);
		}
		
		return cliente;
	}

	@Override
	public int deletar(int id){
		PreparedStatement stmt = null;
		try {
			
			String sql = "DELETE FROM entregas.tbCliente where id = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, String.valueOf(id));
			stmt.execute();

			JOptionPane.showMessageDialog(null,"Cliente excluido com Sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}finally {
			GerenciadorConexao.closeStatement(stmt);
			GerenciadorConexao.closeConnection(conn);
		}
		
		return 0;
	}

}
