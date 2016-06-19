package br.com.setaprox.sgam.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.ContasPagar;

@Local
public interface ContasPagarService {
	void persist(ContasPagar contaPagar);
	
	void merge(ContasPagar contaPagar);
	
	List<ContasPagar> findAll();
	
	ContasPagar find(Long id);
	
	void remove(Long id) throws PersistenceException;
	
	List<ContasPagar> contasVencimentoMensal(Date data);
}
