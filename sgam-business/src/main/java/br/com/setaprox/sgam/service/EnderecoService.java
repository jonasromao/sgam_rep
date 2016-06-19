package br.com.setaprox.sgam.service;

import java.util.List;

import javax.ejb.Local;

import br.com.setaprox.sgam.model.Endereco;

@Local
public interface EnderecoService {
	void persist(Endereco endereco);
	
	void remove(Endereco endereco);
	
	void remove(Long id);
	
	void editar(Endereco endereco);
	
	Endereco find( Long id ) ;	
	
	List<Endereco> findAll();
}
