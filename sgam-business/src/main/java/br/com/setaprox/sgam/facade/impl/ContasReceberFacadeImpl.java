package br.com.setaprox.sgam.facade.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.setaprox.sgam.dto.GraficoDTO;
import br.com.setaprox.sgam.facade.ContasReceberFacade;
import br.com.setaprox.sgam.model.ContasReceber;
import br.com.setaprox.sgam.service.ContasReceberService;

@Named
@RequestScoped
public class ContasReceberFacadeImpl implements ContasReceberFacade {

	@EJB
	private ContasReceberService contasReceberService;
	
	@Override
	public void persist(ContasReceber contaReceber) {
		contasReceberService.persist(contaReceber);
	}
	
	@Override
	public void merge(ContasReceber contaReceber) {
		contasReceberService.merge(contaReceber);
	}
	
	@Override
	public List<ContasReceber> findAll() {
		return contasReceberService.findAll();
	}

	@Override
	public ContasReceber find(Long id) {
		return contasReceberService.find(id);
	}

	@Override
	public void remove(Long id) {
		contasReceberService.remove(id);
	}

	@Override
	public List<ContasReceber> findAllByCategoria(String nomeCategoria) {
		return contasReceberService.findAllByCategoria(nomeCategoria);
	}

	@Override
	public List<ContasReceber> findAllByMorador(Long idMorador) {
		return contasReceberService.findAllByMorador(idMorador);
	}

	@Override
	public List<ContasReceber> findAllByPeriodo(Date dataInicio, Date dataFim, String categoria, String status) {
		return contasReceberService.findAllByPeriodo(dataInicio, dataFim, categoria, status);
	}

	@Override
	public GraficoDTO findToChart(Date dataInicio, Date dataFim, String status, String agrupamento) {
		return contasReceberService.findToChart(dataInicio, dataFim, status, agrupamento);
	}

}
