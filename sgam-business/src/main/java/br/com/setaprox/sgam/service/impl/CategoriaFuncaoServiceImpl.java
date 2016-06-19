package br.com.setaprox.sgam.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.DAO.CategoriaFuncaoDAO;
import br.com.setaprox.sgam.model.CategoriaFuncao;
import br.com.setaprox.sgam.service.CategoriaFuncaoService;

@Stateless
@LocalBean
public class CategoriaFuncaoServiceImpl implements CategoriaFuncaoService {

	@EJB
	private CategoriaFuncaoDAO categoriaFuncaoDAO; 
	
	@Override
	public void persist(CategoriaFuncao categoriaFuncao) {
		categoriaFuncaoDAO.persist(categoriaFuncao);
	}

	@Override
	public void remove(CategoriaFuncao categoriaFuncao) {
		categoriaFuncaoDAO.remove(categoriaFuncao);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		categoriaFuncaoDAO.remove(id);
	}

	@Override
	public void editar(CategoriaFuncao categoriaFuncao) {
		categoriaFuncaoDAO.editar(categoriaFuncao);
	}

	@Override
	public CategoriaFuncao find(Long id) {
		return categoriaFuncaoDAO.find(id);
	}

	@Override
	public List<CategoriaFuncao> findAll() {
		return categoriaFuncaoDAO.findAll();
	}

}
