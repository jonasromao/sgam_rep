package br.com.setaprox.sgam.DAO.impl;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.RecursoDAO;
import br.com.setaprox.sgam.model.Recurso;

@Stateless
@LocalBean
public class RecursoDAOImpl extends AbstractDAO<Recurso> implements RecursoDAO {

	@PostConstruct
	private void postConstruct() {

		setPersistentClass(Recurso.class);

	}

	@Override
	public void editar(Recurso recurso) {
		em.merge(recurso);
		em.flush();
	}
	
	@Override
	public void remove(Long id) {
		em.remove( em.getReference( Recurso.class, id ));
	}

}
