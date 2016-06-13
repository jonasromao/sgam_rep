package br.com.setaprox.sgam.facade.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.setaprox.sgam.facade.AluguelFacade;
import br.com.setaprox.sgam.model.Aluguel;
import br.com.setaprox.sgam.service.AluguelService;
import br.com.setaprox.sgam.service.ContasReceberService;

@Named
@RequestScoped
public class AluguelFacadeImpl implements AluguelFacade {

	@EJB
	private AluguelService aluguelService;
	
	@EJB
	private ContasReceberService contasReceberService;
	
	
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
		//ContasReceber conta = new ContasReceber(aluguel);
		//contasReceberService.persist(conta);
		//aluguel.setContaReceber(conta);
		
		aluguel.setDataEmissaoFaturamento(new Date());
		aluguelService.persist(aluguel);	
	}

}
