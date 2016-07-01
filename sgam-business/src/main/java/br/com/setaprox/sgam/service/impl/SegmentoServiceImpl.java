package br.com.setaprox.sgam.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.DAO.SegmentoDAO;
import br.com.setaprox.sgam.model.Segmento;
import br.com.setaprox.sgam.service.SegmentoService;

@Stateless
@LocalBean
public class SegmentoServiceImpl implements SegmentoService {

	@EJB
	private SegmentoDAO segmentoDAO; 
	
	@Override
	public void persist(Segmento segmento) {
		segmentoDAO.persist(segmento);
	}

	@Override
	public void remove(Segmento segmento) {
		segmentoDAO.remove(segmento);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		segmentoDAO.remove(id);
	}

	@Override
	public void editar(Segmento segmento) {
		segmentoDAO.editar(segmento);
	}

	@Override
	public Segmento find(Long id) {
		return segmentoDAO.find(id);
	}

	@Override
	public List<Segmento> findAll() {
		return segmentoDAO.findAll();
	}

}
