package br.com.setaprox.sgam.DAO;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.CategoriaFuncao;

@Local
public interface CategoriaFuncaoDAO {
	void persist(CategoriaFuncao categoriaFuncao ) ;
	
	void remove(CategoriaFuncao categoriaFuncao);
	
	void remove(Long id) throws PersistenceException;
	
	void editar(CategoriaFuncao categoriaFuncao);
	
	CategoriaFuncao find( Long id ) ;
	
	List<CategoriaFuncao> findAll();
}
