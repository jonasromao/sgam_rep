package br.com.setaprox.sgam.facade.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.setaprox.sgam.constante.Categoria;
import br.com.setaprox.sgam.facade.AluguelFacade;
import br.com.setaprox.sgam.model.Aluguel;
import br.com.setaprox.sgam.model.CategoriaContasReceber;
import br.com.setaprox.sgam.service.AluguelService;
import br.com.setaprox.sgam.service.CategoriaContasReceberService;
import br.com.setaprox.sgam.service.ContasReceberService;

@Named
@RequestScoped
public class AluguelFacadeImpl implements AluguelFacade {

	@EJB
	private AluguelService aluguelService;
	
	@EJB
	private CategoriaContasReceberService categoriaService;
	
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
		aluguelService.persist(aluguel);
		
		CategoriaContasReceber categoria = categoriaService.find(Categoria.ALUGUEL.getCodigo());
		contasReceberService.registraContaReceber(aluguel, categoria);
	}

	@Override
	public List<Aluguel> reservasPorDia(Date data) {
		return aluguelService.reservasPorDia(data);
	}

}
