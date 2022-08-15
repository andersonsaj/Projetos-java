package model.dao;

import java.util.List;

import model.entities.Pessoa;

public interface PessoaDao {
	
	void insert(Pessoa obj);
	void update(Pessoa obj);
	void deleteById(Integer id);
	Pessoa findByIdPessoa(Integer id);
	List<Pessoa> findAllPessoa();

}
