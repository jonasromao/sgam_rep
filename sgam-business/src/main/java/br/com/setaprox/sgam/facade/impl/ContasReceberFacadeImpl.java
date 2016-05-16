package br.com.setaprox.sgam.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.setaprox.sgam.facade.ContasReceberFacade;
import br.com.setaprox.sgam.model.ContasReceber;
import br.com.setaprox.sgam.service.ContasReceberService;

@Named
@RequestScoped
public class ContasReceberFacadeImpl implements ContasReceberFacade {

	@EJB
	private ContasReceberService contasReceberService;
	
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

}
