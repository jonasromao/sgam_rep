package br.com.setaprox.sgam.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.DAO.ComercioDAO;
import br.com.setaprox.sgam.model.Comercio;
import br.com.setaprox.sgam.service.ComercioService;

@Stateless
@LocalBean
public class ComercioServiceImpl implements ComercioService {

	@EJB
	private ComercioDAO comercioDAO; 
	
	@Override
	public void persist(Comercio comercio) {
		comercioDAO.persist(comercio);
	}

	@Override
	public void remove(Comercio comercio) {
		comercioDAO.remove(comercio);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		comercioDAO.remove(id);
	}

	@Override
	public void editar(Comercio comercio) {
		comercioDAO.editar(comercio);
	}

	@Override
	public Comercio find(Long id) {
		return comercioDAO.find(id);
	}

	@Override
	public List<Comercio> findAll() {
		return comercioDAO.findAll();
	}

}
