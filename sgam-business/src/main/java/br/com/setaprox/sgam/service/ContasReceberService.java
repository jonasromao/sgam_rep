package br.com.setaprox.sgam.service;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.Aluguel;
import br.com.setaprox.sgam.model.AluguelComercio;
import br.com.setaprox.sgam.model.ContasReceber;

@Local
public interface ContasReceberService {
	
	void persist(ContasReceber contaReceber);
	
	void merge(ContasReceber contaReceber);
	
	List<ContasReceber> findAll();
	
	ContasReceber find(Long id);
	
	void remove(Long id) throws PersistenceException;
	
	void registraContaReceber(Aluguel aluguel);
	
	void registraContaReceber(AluguelComercio aluguelComercio);

}
