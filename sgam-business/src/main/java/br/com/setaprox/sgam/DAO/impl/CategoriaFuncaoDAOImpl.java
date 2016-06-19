package br.com.setaprox.sgam.DAO.impl;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.CategoriaFuncaoDAO;
import br.com.setaprox.sgam.model.CategoriaFuncao;

@Stateless
@LocalBean
public class CategoriaFuncaoDAOImpl extends AbstractDAO<CategoriaFuncao> implements CategoriaFuncaoDAO {

	@PostConstruct
	private void postConstruct() {
		setPersistentClass(CategoriaFuncao.class);
	}

	@Override
	public void editar(CategoriaFuncao categoriaFuncao) {
		em.merge(categoriaFuncao);
		em.flush();
	}
	
	@Override
	public void remove(Long id) {
		em.remove( em.getReference( CategoriaFuncao.class, id ));
	}

}
