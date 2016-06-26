package br.com.setaprox.sgam.facade;

import java.util.List;

import br.com.setaprox.sgam.model.ContasReceber;

public interface ContasReceberFacade {

	void persist(ContasReceber contaReceber);
	
	void merge(ContasReceber contaReceber);
	
	ContasReceber find( Long id ) ;
	
	List<ContasReceber> findAll() ;
	
	void remove(Long id);
	
	List<ContasReceber> findAllByCategoria(String nomeCategoria);
	
	List<ContasReceber> findAllByMorador(Long idMorador);
	
}
