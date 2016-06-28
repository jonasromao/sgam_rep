package br.com.setaprox.sgam.facade;

import java.util.List;

import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.Comercio;

public interface ComercioFacade {
	void persist(Comercio comercio) ;
	
	void remove(Comercio comercio);
	
	void remove(Long id) throws PersistenceException;
	
	void editar(Comercio comercio);
	
	Comercio find(Long id) ;
	
	List<Comercio> findAll();
}
