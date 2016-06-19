package br.com.setaprox.sgam.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.setaprox.sgam.facade.RecursoFacade;
import br.com.setaprox.sgam.model.Recurso;
import br.com.setaprox.sgam.service.RecursoService;

@Named
@RequestScoped
public class RecursoFacadeImpl implements RecursoFacade {

	@EJB
	private RecursoService recursoService;

	@Override
	public List<Recurso> findAll() {
		return recursoService.findAll();
	}

	@Override
	public void persist(Recurso recurso) {
		recursoService.persist(recurso);
	}

	@Override
	public void remove(Recurso recurso) {
		recursoService.remove(recurso);
	}

	@Override
	public void remove(Long id) {
		recursoService.remove(id);
	}

	@Override
	public void editar(Recurso recurso) {
		recursoService.editar(recurso);
	}

	@Override
	public Recurso find(Long id) {
		return recursoService.find(id);
	}
	
}
