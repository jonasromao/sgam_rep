package br.com.setaprox.sgam.service;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.Segmento;

@Local
public interface SegmentoService {
	void persist(Segmento segmento) ;
	
	void remove(Segmento segmento);
	
	void remove(Long id) throws PersistenceException;
	
	void editar(Segmento segmento);
	
	Segmento find(Long id) ;
	
	List<Segmento> findAll();
}
