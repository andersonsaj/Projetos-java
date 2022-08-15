package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.PessoaDao;
import model.dao.TelefoneDao;
import model.entities.Pessoa;
import model.entities.Telefone;

public class PessoaDaoJDBC implements PessoaDao, TelefoneDao {
	
	private Connection conn;
	private Integer idP;

	public PessoaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Pessoa obj) {
		PreparedStatement st = null;
	
		try {
			st = conn.prepareStatement("insert into pessoa " + 
		"(nome, cpf, nascimento, sexo, rg, email, estado_civil, status) "
					+ "values(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setDate(3, new java.sql.Date(obj.getNascimento().getTime()));
			st.setString(4, String.valueOf(obj.getSexo()));
			st.setString(5,obj.getRg());
			st.setString(6, obj.getEmail());
			st.setString(7, obj.getEstadoCivil());
			st.setString(8, obj.getStatus());
	
			int ra = st.executeUpdate();
			if (ra > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					idP = rs.getInt(1);
					obj.setId(idP);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Error! No rows affect");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}	
	}
	@Override
	public void insert(Telefone obj) {
		
		PreparedStatement st1 = null;
		
		try {
			st1 = conn.prepareStatement("insert into telefone " 
					+"(TIPO, NUMERO, ID_PESSOA) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st1.setString(1, obj.getTipo());
			st1.setString(2, obj.getNumero());
			st1.setInt(3, idP);
	
			int ra = st1.executeUpdate();
			if (ra > 0) {
				ResultSet rs = st1.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Error! No rows affect");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st1);
		}	
		
	}
	
	//
	@Override
	public void update(Pessoa obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("update pessoa " +
			"set nome =?, cpf = ?, nascimento=?, sexo=?, rg=?, email=?, estado_civil=?, status=?" 
					+ "where idpessoa =?");
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setDate(3, new java.sql.Date(obj.getNascimento().getTime()));
			st.setString(4, String.valueOf(obj.getSexo()));
			st.setString(5,obj.getRg());
			st.setString(6, obj.getEmail());
			st.setString(7, obj.getEstadoCivil());
			st.setString(8, obj.getStatus());
			
			st.setInt(9, obj.getId());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st= conn.prepareStatement(
					"delete from pessoa where id = ?");
		st.setInt(1,id);
		st.executeUpdate();
	
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Pessoa findByIdPessoa(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("select * from department where ID = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Pessoa obj = instPessoa(rs);
						
				return obj;	
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return null;
	}
	
	private Pessoa instPessoa(ResultSet rs) throws SQLException {
		Pessoa obj = new Pessoa();
		obj.setId(rs.getInt("ID"));
		obj.setNome(rs.getString("NOME"));
		obj.setCpf(rs.getString("CPF"));
		obj.setNascimento(new java.util.Date(rs.getTimestamp("NASCIMENTO").getTime()));
		String s = rs.getString("SEXO");
		obj.setSexo(s.charAt(0));
		obj.setRg(rs.getString("RG"));
		obj.setEmail(rs.getString("EMAIL"));
		obj.setEstadoCivil(rs.getString("ESTADO_CIVIL"));
		obj.setStatus(rs.getString("STATUS"));
		
		return obj;
	}

	@Override
	public List<Pessoa> findAllPessoa() {
		
		return null;
	}

	@Override
	public void update(Telefone obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Telefone findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Telefone> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
