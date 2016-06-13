package br.com.setaprox.sgam.DAO.impl;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.ContasPagarDAO;
import br.com.setaprox.sgam.model.ContasPagar;

@Stateless
@LocalBean
public class ContasPagarDAOImpl extends AbstractDAO<ContasPagar> implements ContasPagarDAO {

	@PostConstruct
	private void postConstruct() {

		setPersistentClass(ContasPagar.class);

	}

	public void editar(ContasPagar contaPagar) {
		em.merge(contaPagar);
		em.flush();
	}

}
