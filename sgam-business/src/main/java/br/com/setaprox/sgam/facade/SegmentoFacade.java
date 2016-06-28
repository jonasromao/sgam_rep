package br.com.setaprox.sgam.facade;

import java.util.List;

import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.Segmento;

public interface SegmentoFacade {
	void persist(Segmento segmento) ;
	
	void remove(Segmento segmento);
	
	void remove(Long id) throws PersistenceException;
	
	void editar(Segmento segmento);
	
	Segmento find(Long id) ;
	
	List<Segmento> findAll();
}
