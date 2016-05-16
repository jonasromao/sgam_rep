package br.com.setaprox.sgam.facade;

import java.util.List;

import br.com.setaprox.sgam.model.ContasReceber;

public interface ContasReceberFacade {

	ContasReceber find( Long id ) ;
	
	List<ContasReceber> findAll() ;
	
	void remove(Long id);
	
}
