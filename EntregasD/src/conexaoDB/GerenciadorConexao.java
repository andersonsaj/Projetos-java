package conexaoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GerenciadorConexao {

	private static Connection conexao =null;

	private GerenciadorConexao() {

	}

	public static Connection getConexao() {
		try {
			String className = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/entregas?user=Desenvolvedor&password=1234";

			if (conexao == null) {
				Class.forName(className);
				conexao = DriverManager.getConnection(url);
			}
			return conexao;
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
				st = null;
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}
