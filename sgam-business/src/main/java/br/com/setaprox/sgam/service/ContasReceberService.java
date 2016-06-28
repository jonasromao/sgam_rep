package br.com.setaprox.sgam.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.Aluguel;
import br.com.setaprox.sgam.model.AluguelComercio;
import br.com.setaprox.sgam.model.CategoriaContasReceber;
import br.com.setaprox.sgam.model.ContasReceber;
import br.com.setaprox.sgam.model.Morador;

@Local
public interface ContasReceberService {
	
	void persist(ContasReceber contaReceber);
	
	void merge(ContasReceber contaReceber);
	
	List<ContasReceber> findAll();
	
	ContasReceber find(Long id);
	
	void remove(Long id) throws PersistenceException;
	
	void registraContaReceber(Aluguel aluguel, CategoriaContasReceber categoria);
	
	void registraContaReceber(AluguelComercio aluguelComercio, CategoriaContasReceber categoria);
	
	void registraContaReceber(Morador morador, CategoriaContasReceber categoria);
	
	List<ContasReceber> findAllByCategoria(String nomeCategoria);
	
	List<ContasReceber> findAllByMorador(Long idMorador);
	
	List<ContasReceber> findAllByPeriodo(Date dataInicio, Date dataFim, String categoria, String status);

}
