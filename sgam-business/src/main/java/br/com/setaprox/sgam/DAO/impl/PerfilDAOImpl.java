package br.com.setaprox.sgam.DAO.impl;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.PerfilDAO;
import br.com.setaprox.sgam.model.Perfil;

@Stateless
@LocalBean
public class PerfilDAOImpl extends AbstractDAO<Perfil> implements PerfilDAO {
	
	@PostConstruct
	private void postConstruct() {
		setPersistentClass(Perfil.class);
	}

	@Override
	public void editar(Perfil perfil) {
		em.merge(perfil);
		em.flush();
	}
	
	@Override
	public void remove(Long id) {
		em.remove( em.getReference( Perfil.class, id ));
	}
}
