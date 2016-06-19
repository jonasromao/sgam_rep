package br.com.setaprox.sgam.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.DAO.PerfilDAO;
import br.com.setaprox.sgam.model.Perfil;
import br.com.setaprox.sgam.service.PerfilService;

@Stateless
@LocalBean
public class PerfilServiceImpl implements PerfilService {

	@EJB
	private PerfilDAO perfilDAO;
	
	@Override
	public void persist(Perfil perfil) {
		perfilDAO.persist(perfil);
	}

	@Override
	public void remove(Perfil perfil) {
		perfilDAO.remove(perfil);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		perfilDAO.remove(id);
	}

	@Override
	public void editar(Perfil perfil) {
		perfilDAO.editar(perfil);
	}

	@Override
	public Perfil find(Long id) {
		return perfilDAO.find(id);
	}

	@Override
	public List<Perfil> findAll() {
		return perfilDAO.findAll();
	}

}
