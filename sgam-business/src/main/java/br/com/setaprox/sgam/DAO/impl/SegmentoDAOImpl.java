package br.com.setaprox.sgam.DAO.impl;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.SegmentoDAO;
import br.com.setaprox.sgam.model.Segmento;

@Stateless
@LocalBean
public class SegmentoDAOImpl extends AbstractDAO<Segmento> implements SegmentoDAO {
	
	@PostConstruct
	private void postConstruct() {
		setPersistentClass(Segmento.class);
	}

	@Override
	public void editar(Segmento segmento) {
		em.merge(segmento);
		em.flush();
	}
	
	@Override
	public void remove(Long id) {
		em.remove( em.getReference(Segmento.class, id));
	}
}
