package br.com.setaprox.sgam.service;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.ContasReceber;

@Local
public interface ContasReceberService {
	
	List<ContasReceber> findAll();
	
	ContasReceber find(Long id);
	
	void remove(Long id) throws PersistenceException;

}
