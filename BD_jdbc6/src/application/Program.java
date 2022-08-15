package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);
			st= conn.createStatement();
			
			int ra = st.executeUpdate("update seller set BaseSalary = 2090 where DepartmentId = 1");
			
			/*int x= 1;
			if(x<2) {
				throw new SQLException("Fake error");
			}*/
			int ra1 = st.executeUpdate("update seller set BaseSalary = 3090 where DepartmentId = 2");
			conn.commit();
			System.out.printf("Rows1: " + ra +"\n" + "Rows2: " + ra +"\n");
		}
		catch(SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused by: "+ e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error RollBack " + e1.getMessage());
			}
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}
}
