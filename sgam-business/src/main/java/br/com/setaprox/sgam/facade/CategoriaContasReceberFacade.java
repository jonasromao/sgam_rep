package br.com.setaprox.sgam.facade;

import java.util.List;

import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.CategoriaContasReceber;

public interface CategoriaContasReceberFacade {
	
	void persist(CategoriaContasReceber categoria ) ;
	
	void remove(CategoriaContasReceber categoria);
	
	void remove(Long id) throws PersistenceException;
	
	void editar(CategoriaContasReceber categoria);
	
	CategoriaContasReceber find(Long id) ;
	
	CategoriaContasReceber find(String nome);
	
	List<CategoriaContasReceber> findAll();
}
