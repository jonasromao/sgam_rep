package br.com.setaprox.sgam.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.facade.SegmentoFacade;
import br.com.setaprox.sgam.model.Segmento;
import br.com.setaprox.sgam.service.SegmentoService;

@Named
@RequestScoped
public class SegmentoFacadeImpl implements SegmentoFacade {

	@EJB
	private SegmentoService segmentoService;
	
	@Override
	public void persist(Segmento segmento) {
		segmentoService.persist(segmento);
	}

	@Override
	public void remove(Segmento segmento) {
		segmentoService.remove(segmento);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		segmentoService.remove(id);
	}

	@Override
	public void editar(Segmento segmento) {
		segmentoService.editar(segmento);
	}

	@Override
	public Segmento find(Long id) {
		return segmentoService.find(id);
	}

	@Override
	public List<Segmento> findAll() {
		return segmentoService.findAll();
	}

}
