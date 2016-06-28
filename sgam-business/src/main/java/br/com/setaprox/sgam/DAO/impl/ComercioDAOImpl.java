package br.com.setaprox.sgam.DAO.impl;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.ComercioDAO;
import br.com.setaprox.sgam.model.Comercio;

@Stateless
@LocalBean
public class ComercioDAOImpl extends AbstractDAO<Comercio> implements ComercioDAO {

	@PostConstruct
	private void postConstruct() {
		setPersistentClass(Comercio.class);
	}

	@Override
	public void editar(Comercio comercio) {
		em.merge(comercio);
		em.flush();
	}
	
	@Override
	public void remove(Long id) {
		em.remove( em.getReference( Comercio.class, id ));
	}
}
