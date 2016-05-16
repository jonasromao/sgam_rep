package br.com.setaprox.sgam.facade;

import java.util.List;

import br.com.setaprox.sgam.model.Fornecedor;

public interface FornecedorFacade {

	List<Fornecedor> findAll();
	
	void editar( Fornecedor fornecedor );
	
	void persist( Fornecedor fornecedor ) ;
	
	Fornecedor find( Long id ) ;
	
	void remove(Long id);
	
}
