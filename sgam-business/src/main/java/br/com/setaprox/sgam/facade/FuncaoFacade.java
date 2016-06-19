package br.com.setaprox.sgam.facade;

import java.util.List;

import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.Funcao;

public interface FuncaoFacade {
	void persist(Funcao funcao ) ;
	
	void remove(Funcao funcao);
	
	void remove(Long id) throws PersistenceException;
	
	void editar(Funcao funcao);
	
	Funcao find( Long id ) ;
	
	List<Funcao> findAll();
}
