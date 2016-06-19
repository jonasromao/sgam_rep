package br.com.setaprox.sgam.facade;

import java.util.List;

import br.com.setaprox.sgam.model.Recurso;

public interface RecursoFacade {

	void persist(Recurso recurso);

	void remove(Recurso recurso);

	void remove(Long id);

	void editar(Recurso recurso);

	Recurso find(Long id);

	List<Recurso> findAll();
	
}
