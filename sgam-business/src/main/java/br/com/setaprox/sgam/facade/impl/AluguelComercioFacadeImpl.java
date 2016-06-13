package br.com.setaprox.sgam.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.setaprox.sgam.facade.AluguelComercioFacade;
import br.com.setaprox.sgam.model.AluguelComercio;
import br.com.setaprox.sgam.service.AluguelComercioService;
import br.com.setaprox.sgam.service.ContasReceberService;

@Named
@RequestScoped
public class AluguelComercioFacadeImpl implements AluguelComercioFacade {

	@EJB
	private AluguelComercioService aluguelComercioService;
	
	@EJB
	private ContasReceberService contasReceberService;
	
	
	@Override
	public List<AluguelComercio> findAll() {
		
		return aluguelComercioService.findAll();
		
	}


	@Override
	public void editar(AluguelComercio aluguelComercio) {
		
		aluguelComercioService.editar(aluguelComercio);
		
	}


	@Override
	public AluguelComercio find(Long id) {
		
		return aluguelComercioService.find(id);
		
	}


	@Override
	public void remove(Long id) {
		
		aluguelComercioService.remove(id);
		
	}


	@Override
	public void persist(AluguelComercio aluguelComercio) {
		//ContasReceber conta = new ContasReceber(aluguelComercio);
		//contasReceberService.persist(conta);

		//aluguelComercio.getAluguel().setContaReceber(conta);
		aluguelComercioService.persist(aluguelComercio);	
	}

}
