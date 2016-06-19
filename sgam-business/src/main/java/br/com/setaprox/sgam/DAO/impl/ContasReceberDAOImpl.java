package br.com.setaprox.sgam.DAO.impl;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.ContasReceberDAO;
import br.com.setaprox.sgam.model.ContasReceber;

@Stateless
@LocalBean
public class ContasReceberDAOImpl extends AbstractDAO<ContasReceber> implements ContasReceberDAO {

	@PostConstruct
	private void postConstruct() {

		setPersistentClass(ContasReceber.class);

	}

	@Override
	public void editar(ContasReceber contasReceber) {
		em.merge(contasReceber);
		em.flush();
	}
	
	@Override
	public void remove(Long id) {
		em.remove( em.getReference( ContasReceber.class, id ));
	}

}
