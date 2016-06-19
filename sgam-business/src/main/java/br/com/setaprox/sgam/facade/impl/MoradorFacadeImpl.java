package br.com.setaprox.sgam.facade.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.setaprox.sgam.facade.MoradorFacade;
import br.com.setaprox.sgam.model.Morador;
import br.com.setaprox.sgam.service.MoradorService;

@Named
@RequestScoped
public class MoradorFacadeImpl implements MoradorFacade {

	@EJB
	private MoradorService moradorService;
	
	@Override
	public List<Morador> findAll() {
		
		return moradorService.findAll();
		
	}

	@Override
	public void editar(Morador morador) {

		moradorService.editar(morador);
		
	}

	@Override
	public void persist(Morador morador) {
		
		moradorService.persist(morador);
		
	}

	@Override
	public Morador find(Long id) {
		
		return moradorService.find(id);
		
	}

	@Override
	public void remove(Long id) {

		moradorService.remove(id);
		
	}

	@Override
	public List<Morador> findByNome(String nome) {
		List<Morador> moradores = null;
		
		if(nome != null && !nome.isEmpty()){
			nome = nome.trim();
			
			moradores = moradorService.findByNome(nome);
		}
		else {
			moradores = this.findAll();
		}
		
		return moradores;
	}

	@Override
	public long totalMoradores() {
		return moradorService.totalMoradores();
	}

	@Override
	public long totalAssociados(Date inicio, Date fim) {
		return moradorService.totalAssociados(inicio, fim);
	}
	
}
