package br.com.setaprox.sgam.service;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.CategoriaContasReceber;

@Local
public interface CategoriaContasReceberService {
	
	void persist(CategoriaContasReceber categoria ) ;
	
	void remove(CategoriaContasReceber categoria);
	
	void remove(Long id) throws PersistenceException;
	
	void editar(CategoriaContasReceber categoria);
	
	CategoriaContasReceber find(Long id) ;
	
	CategoriaContasReceber find(String nome);
	
	List<CategoriaContasReceber> findAll();
	
}
