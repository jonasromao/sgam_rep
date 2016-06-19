package br.com.setaprox.sgam.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.facade.FuncaoFacade;
import br.com.setaprox.sgam.model.Funcao;
import br.com.setaprox.sgam.service.FuncaoService;

@Named
@RequestScoped
public class FuncaoFacadeImpl implements FuncaoFacade {

	@EJB
	private FuncaoService funcaoService;
	
	@Override
	public void persist(Funcao funcao) {
		funcaoService.persist(funcao);
	}

	@Override
	public void remove(Funcao funcao) {
		funcaoService.remove(funcao);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		funcaoService.remove(id);
	}

	@Override
	public void editar(Funcao funcao) {
		funcaoService.editar(funcao);
	}

	@Override
	public Funcao find(Long id) {
		return funcaoService.find(id);
	}

	@Override
	public List<Funcao> findAll() {
		return funcaoService.findAll();
	}

}
