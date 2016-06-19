package br.com.setaprox.sgam.facade.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.setaprox.sgam.facade.ContasPagarFacade;
import br.com.setaprox.sgam.model.ContasPagar;
import br.com.setaprox.sgam.service.ContasPagarService;

@Named
@RequestScoped
public class ContasPagarFacadeImpl implements ContasPagarFacade {

	@EJB
	private ContasPagarService contasPagarService;
	
	@Override
	public void persist(ContasPagar contaPagar) {
		contasPagarService.persist(contaPagar);
	}

	@Override
	public void merge(ContasPagar contaPagar) {
		contasPagarService.merge(contaPagar);
	}

	@Override
	public ContasPagar find(Long id) {
		return contasPagarService.find(id);
	}

	@Override
	public List<ContasPagar> findAll() {
		return contasPagarService.findAll();
	}

	@Override
	public void remove(Long id) {
		contasPagarService.remove(id);
	}

	@Override
	public List<ContasPagar> contasVencimentoMensal(Date data) {
		return contasPagarService.contasVencimentoMensal(data);
	}

}
