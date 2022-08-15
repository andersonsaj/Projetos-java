package model.dao;

import db.DB;
import model.dao.impl.PessoaDaoJDBC;

public class DaoFactory {
	
	public static PessoaDao createPessoaDao() {
		return new PessoaDaoJDBC(DB.getConnection());
	}
	
	public static TelefoneDao createTelefoneDao() {
		return new PessoaDaoJDBC(DB.getConnection());
	}

}
