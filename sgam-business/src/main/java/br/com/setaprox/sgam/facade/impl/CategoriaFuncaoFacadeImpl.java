package br.com.setaprox.sgam.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.facade.CategoriaFuncaoFacade;
import br.com.setaprox.sgam.model.CategoriaFuncao;
import br.com.setaprox.sgam.service.CategoriaFuncaoService;

@Named
@RequestScoped
public class CategoriaFuncaoFacadeImpl implements CategoriaFuncaoFacade {

	@EJB
	private CategoriaFuncaoService categoriaFuncaoService;
	
	@Override
	public void persist(CategoriaFuncao categoriaFuncao) {
		categoriaFuncaoService.persist(categoriaFuncao);
	}

	@Override
	public void remove(CategoriaFuncao categoriaFuncao) {
		categoriaFuncaoService.remove(categoriaFuncao);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		categoriaFuncaoService.remove(id);
	}

	@Override
	public void editar(CategoriaFuncao categoriaFuncao) {
		categoriaFuncaoService.editar(categoriaFuncao);
	}

	@Override
	public CategoriaFuncao find(Long id) {
		return categoriaFuncaoService.find(id);
	}

	@Override
	public List<CategoriaFuncao> findAll() {
		return categoriaFuncaoService.findAll();
	}

}
