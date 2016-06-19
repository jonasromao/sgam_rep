package br.com.setaprox.sgam.facade;

import java.util.List;

import br.com.setaprox.sgam.model.Endereco;

public interface EnderecoFacade {
	void persist(Endereco endereco);
	
	void remove(Endereco endereco);
	
	void remove(Long id);
	
	void editar(Endereco endereco);
	
	Endereco find( Long id ) ;	
	
	List<Endereco> findAll();
}
