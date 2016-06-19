package br.com.setaprox.sgam.DAO.impl;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.FuncaoDAO;
import br.com.setaprox.sgam.model.ContasPagar;
import br.com.setaprox.sgam.model.Funcao;

@Stateless
@LocalBean
public class FuncaoDAOImpl extends AbstractDAO<Funcao> implements FuncaoDAO {
	
	@PostConstruct
	private void postConstruct() {
		setPersistentClass(Funcao.class);
	}

	@Override
	public void editar(Funcao funcao) {
		em.merge(funcao);
		em.flush();
	}
	
	@Override
	public void remove(Long id) {
		em.remove( em.getReference( ContasPagar.class, id ));
	}
}
