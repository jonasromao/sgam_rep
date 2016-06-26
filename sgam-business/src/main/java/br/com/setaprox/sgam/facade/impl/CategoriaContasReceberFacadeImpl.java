package br.com.setaprox.sgam.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.facade.CategoriaContasReceberFacade;
import br.com.setaprox.sgam.model.CategoriaContasReceber;
import br.com.setaprox.sgam.service.CategoriaContasReceberService;

@Named
@RequestScoped
public class CategoriaContasReceberFacadeImpl implements CategoriaContasReceberFacade {

	@EJB
	private CategoriaContasReceberService categoriaService;
	
	@Override
	public void persist(CategoriaContasReceber categoria) {
		categoriaService.persist(categoria);
	}

	@Override
	public void remove(CategoriaContasReceber categoria) {
		categoriaService.remove(categoria);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		categoriaService.remove(id);
	}

	@Override
	public void editar(CategoriaContasReceber categoria) {
		categoriaService.editar(categoria);
	}

	@Override
	public CategoriaContasReceber find(Long id) {
		return categoriaService.find(id);
	}

	@Override
	public CategoriaContasReceber find(String nome) {
		return categoriaService.find(nome);
	}

	@Override
	public List<CategoriaContasReceber> findAll() {
		return categoriaService.findAll();
	}

}
