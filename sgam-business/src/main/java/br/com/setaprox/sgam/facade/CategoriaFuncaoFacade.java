package br.com.setaprox.sgam.facade;

import java.util.List;

import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.CategoriaFuncao;

public interface CategoriaFuncaoFacade {
	void persist(CategoriaFuncao categoriaFuncao ) ;
	
	void remove(CategoriaFuncao categoriaFuncao);
	
	void remove(Long id) throws PersistenceException;
	
	void editar(CategoriaFuncao categoriaFuncao);
	
	CategoriaFuncao find( Long id ) ;
	
	List<CategoriaFuncao> findAll();
}
