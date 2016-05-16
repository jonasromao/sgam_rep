package br.com.setaprox.sgam.DAO;

import javax.ejb.Local;

import br.com.setaprox.sgam.model.Endereco;

@Local
public interface EnderecoDAO {
	
	void persist( Endereco endereco);
	
	Endereco find(Long id);
}
