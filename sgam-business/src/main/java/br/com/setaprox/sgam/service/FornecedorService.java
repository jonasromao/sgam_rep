package br.com.setaprox.sgam.service;

import java.util.List;

import javax.ejb.Local;

import br.com.setaprox.sgam.model.Fornecedor;

@Local
public interface FornecedorService {
	
void persist( Fornecedor fornecedor ) ;
	
	void remove(Fornecedor fornecedor);
	
	void remove(Long id);
	
	void editar( Fornecedor fornecedor );
	
	Fornecedor find( Long id ) ;	
	
	List<Fornecedor> findAll();
	
	List<Fornecedor> findByNome(String nome);

}
