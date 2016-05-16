package br.com.setaprox.sgam.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.RecursoDAO;
import br.com.setaprox.sgam.model.Recurso;
import br.com.setaprox.sgam.service.RecursoService;

@Stateless
@LocalBean
public class RecursoServiceImpl implements RecursoService {

	@EJB
	private RecursoDAO recursoDAO;
	
	@Override
	public void persist(Recurso recurso) {
		
		recursoDAO.persist(recurso);
		
	}

	@Override
	public void remove(Recurso recurso) {
		
		recursoDAO.remove(recurso);
		
	}

	@Override
	public void remove(Long id) {
		
		recursoDAO.remove(id);
		
	}

	@Override
	public void editar(Recurso recurso) {
		
		recursoDAO.editar(recurso);
		
	}

	@Override
	public Recurso find(Long id) {
		
		return recursoDAO.find(id);
		
	}

	@Override
	public List<Recurso> findAll() {
		
		return recursoDAO.findAll();
		
	}

}
