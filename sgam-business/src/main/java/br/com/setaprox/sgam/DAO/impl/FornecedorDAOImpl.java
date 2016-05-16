package br.com.setaprox.sgam.DAO.impl;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.FornecedorDAO;
import br.com.setaprox.sgam.model.Fornecedor;

@Stateless
@LocalBean
public class FornecedorDAOImpl extends AbstractDAO<Fornecedor> implements
		FornecedorDAO {

	@PostConstruct
	private void postConstruct() {

		setPersistentClass(Fornecedor.class);

	}

	public void editar(Fornecedor fornecedor) {
		em.merge(fornecedor);
		em.flush();
	}

}
