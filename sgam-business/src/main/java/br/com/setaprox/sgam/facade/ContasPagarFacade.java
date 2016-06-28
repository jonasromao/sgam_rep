package br.com.setaprox.sgam.facade;

import java.util.Date;
import java.util.List;

import br.com.setaprox.sgam.model.ContasPagar;

public interface ContasPagarFacade {
	void persist(ContasPagar contaPagar);
	
	void merge(ContasPagar contaPagar);
	
	ContasPagar find( Long id ) ;
	
	List<ContasPagar> findAll() ;
	
	void remove(Long id);
	
	List<ContasPagar> contasVencimentoMensal(Date data);
	
	List<ContasPagar> findAllByPeriodo(Date dataInicio, Date dataFim, String status);
}
