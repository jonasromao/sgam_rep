package br.com.setaprox.sgam.facade;

import java.util.List;

import br.com.setaprox.sgam.model.Morador;

public interface MoradorFacade {
	
	List<Morador> findAll();
	
	void editar(Morador morador);
	
	void persist(Morador morador);
	
	Morador find(Long id);
	
	void remove(Long id);
}
