package br.com.setaprox.sgam.service;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.Funcao;

@Local
public interface FuncaoService {
	void persist(Funcao funcao ) ;
	
	void remove(Funcao funcao);
	
	void remove(Long id) throws PersistenceException;
	
	void editar(Funcao funcao);
	
	Funcao find( Long id ) ;
	
	List<Funcao> findAll();
}
