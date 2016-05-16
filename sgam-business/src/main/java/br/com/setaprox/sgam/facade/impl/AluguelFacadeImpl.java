package br.com.setaprox.sgam.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.setaprox.sgam.facade.AluguelFacade;
import br.com.setaprox.sgam.model.Aluguel;
import br.com.setaprox.sgam.service.AluguelService;

@Named
@RequestScoped
public class AluguelFacadeImpl implements AluguelFacade {

	@EJB
	private AluguelService aluguelService;
	
	
	@Override
	public List<Aluguel> findAll() {
		
		return aluguelService.findAll();
		
	}


	@Override
	public void editar(Aluguel aluguel) {
		
		aluguelService.editar(aluguel);
		
	}


	@Override
	public Aluguel find(Long id) {
		
		return aluguelService.find(id);
		
	}


	@Override
	public void remove(Long id) {
		
		aluguelService.remove(id);
		
	}


	@Override
	public void persist(Aluguel aluguel) {
		
		aluguelService.persist(aluguel);
		
	}

}
