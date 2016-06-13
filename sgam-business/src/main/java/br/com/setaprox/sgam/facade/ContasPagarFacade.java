package br.com.setaprox.sgam.facade;

import java.util.List;

import br.com.setaprox.sgam.model.ContasPagar;

public interface ContasPagarFacade {
	void persist(ContasPagar contaPagar);
	
	void merge(ContasPagar contaPagar);
	
	ContasPagar find( Long id ) ;
	
	List<ContasPagar> findAll() ;
	
	void remove(Long id);
}
