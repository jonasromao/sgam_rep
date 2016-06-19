package br.com.setaprox.sgam.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.DAO.FuncaoDAO;
import br.com.setaprox.sgam.model.Funcao;
import br.com.setaprox.sgam.service.FuncaoService;

@Stateless
@LocalBean
public class FuncaoServiceImpl implements FuncaoService {

	@EJB
	private FuncaoDAO funcaoDAO;
	
	@Override
	public void persist(Funcao funcao) {
		funcaoDAO.persist(funcao);
	}

	@Override
	public void remove(Funcao funcao) {
		funcaoDAO.remove(funcao);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		funcaoDAO.remove(id);
	}

	@Override
	public void editar(Funcao funcao) {
		funcaoDAO.editar(funcao);
	}

	@Override
	public Funcao find(Long id) {
		return funcaoDAO.find(id);
	}

	@Override
	public List<Funcao> findAll() {
		return funcaoDAO.findAll();
	}

}
