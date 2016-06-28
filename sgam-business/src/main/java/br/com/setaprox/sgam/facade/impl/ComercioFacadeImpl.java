package br.com.setaprox.sgam.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.facade.ComercioFacade;
import br.com.setaprox.sgam.model.Comercio;
import br.com.setaprox.sgam.service.ComercioService;

@Named
@RequestScoped
public class ComercioFacadeImpl implements ComercioFacade {

	@EJB
	private ComercioService comercioService;
	
	@Override
	public void persist(Comercio comercio) {
		comercioService.persist(comercio);
	}

	@Override
	public void remove(Comercio comercio) {
		comercioService.remove(comercio);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		comercioService.remove(id);
	}

	@Override
	public void editar(Comercio comercio) {
		comercioService.editar(comercio);
	}

	@Override
	public Comercio find(Long id) {
		return comercioService.find(id);
	}

	@Override
	public List<Comercio> findAll() {
		return comercioService.findAll();
	}

}
