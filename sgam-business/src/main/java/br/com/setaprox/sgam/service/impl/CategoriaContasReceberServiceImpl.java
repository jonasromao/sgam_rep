package br.com.setaprox.sgam.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.DAO.CategoriaContasReceberDAO;
import br.com.setaprox.sgam.model.CategoriaContasReceber;
import br.com.setaprox.sgam.service.CategoriaContasReceberService;

@Stateless
@LocalBean
public class CategoriaContasReceberServiceImpl implements CategoriaContasReceberService {

	@EJB
	private CategoriaContasReceberDAO categoriaDAO; 
	
	@Override
	public void persist(CategoriaContasReceber categoria) {
		categoriaDAO.persist(categoria);
	}

	@Override
	public void remove(CategoriaContasReceber categoria) {
		categoriaDAO.remove(categoria);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		categoriaDAO.remove(id);
	}

	@Override
	public void editar(CategoriaContasReceber categoria) {
		categoriaDAO.editar(categoria);
	}

	@Override
	public CategoriaContasReceber find(Long id) {
		return categoriaDAO.find(id);
	}

	@Override
	public List<CategoriaContasReceber> findAll() {
		return categoriaDAO.findAll();
	}

	@Override
	public CategoriaContasReceber find(String nome) {
		return categoriaDAO.find(nome);
	}

}
