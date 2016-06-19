package br.com.setaprox.sgam.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.facade.PerfilFacade;
import br.com.setaprox.sgam.model.Perfil;
import br.com.setaprox.sgam.service.PerfilService;

@Named
@RequestScoped
public class PerfilFacadeImpl implements PerfilFacade {

	@EJB
	private PerfilService perfilService;
	
	@Override
	public void persist(Perfil perfil) {
		perfilService.persist(perfil);
	}

	@Override
	public void remove(Perfil perfil) {
		perfilService.remove(perfil);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		perfilService.remove(id);
	}

	@Override
	public void editar(Perfil perfil) {
		perfilService.editar(perfil);
	}

	@Override
	public Perfil find(Long id) {
		return perfilService.find(id);
	}

	@Override
	public List<Perfil> findAll() {
		return perfilService.findAll();
	}

}
