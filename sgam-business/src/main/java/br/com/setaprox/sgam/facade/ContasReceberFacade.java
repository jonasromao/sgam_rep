package br.com.setaprox.sgam.facade;

import java.util.Date;
import java.util.List;

import br.com.setaprox.sgam.dto.GraficoDTO;
import br.com.setaprox.sgam.model.ContasReceber;

public interface ContasReceberFacade {

	void persist(ContasReceber contaReceber);
	
	void merge(ContasReceber contaReceber);
	
	ContasReceber find( Long id ) ;
	
	List<ContasReceber> findAll() ;
	
	void remove(Long id);
	
	List<ContasReceber> findAllByCategoria(String nomeCategoria);
	
	List<ContasReceber> findAllByMorador(Long idMorador);
	
	List<ContasReceber> findAllByPeriodo(Date dataInicio, Date dataFim, String categoria, String status);
	
	GraficoDTO findToChart(Date dataInicio, Date dataFim, String status, String agrupamento);
	
}
