package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.TelefoneDao;
import model.entities.Telefone;

public class TelefoneService {

	private TelefoneDao dao = DaoFactory.createTelefoneDao();
	
	public List<Telefone> findAll(){
		return dao.findAll();
	}
	
	public void saveOrUpdate(Telefone obj) {
		if(obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
	
	public void remove(Telefone obj) {
		dao.deleteById(obj.getId());
	}
}
