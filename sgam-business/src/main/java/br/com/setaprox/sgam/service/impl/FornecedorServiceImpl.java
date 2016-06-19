package br.com.setaprox.sgam.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.FornecedorDAO;
import br.com.setaprox.sgam.model.Fornecedor;
import br.com.setaprox.sgam.service.FornecedorService;

@Stateless
@LocalBean
public class FornecedorServiceImpl implements FornecedorService {

	@EJB
	private FornecedorDAO fornecedorDAO;

	@Override
	public void persist(Fornecedor fornecedor) {
		
		fornecedorDAO.persist(fornecedor);
		
	}

	@Override
	public void remove(Fornecedor fornecedor) {
		
		fornecedorDAO.remove(fornecedor);
		
	}

	@Override
	public void remove(Long id) {
		fornecedorDAO.remove(id);
		
	}

	@Override
	public void editar(Fornecedor fornecedor) {
		fornecedorDAO.editar(fornecedor);
		
	}

	@Override
	public Fornecedor find(Long id) {
		
		return fornecedorDAO.find(id);
		
	}

	@Override
	public List<Fornecedor> findAll() {
		
		return fornecedorDAO.findAll();
		
	}

	@Override
	public List<Fornecedor> findByNome(String nome) {
		return fornecedorDAO.findByNome(nome);
	}
	
}
