package br.com.setaprox.sgam.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.setaprox.sgam.facade.FornecedorFacade;
import br.com.setaprox.sgam.model.Fornecedor;
import br.com.setaprox.sgam.service.FornecedorService;

@Named
@RequestScoped
public class FornecedorFacadeImpl implements FornecedorFacade {

	@EJB
	private FornecedorService fornecedorService;

	@Override
	public List<Fornecedor> findAll() {

		return fornecedorService.findAll();

	}

	@Override
	public void editar(Fornecedor fornecedor) {

		fornecedorService.editar(fornecedor);

	}

	@Override
	public void persist(Fornecedor fornecedor) {

		fornecedorService.persist(fornecedor);

	}

	@Override
	public Fornecedor find(Long id) {

		return fornecedorService.find(id);

	}

	@Override
	public void remove(Long id) {

		fornecedorService.remove(id);

	}

	@Override
	public List<Fornecedor> findByNome(String nome) {
		List<Fornecedor> fornecedores = null;
		
		if(nome != null && !nome.isEmpty()){
			nome = nome.trim();
			
			fornecedores = fornecedorService.findByNome(nome);
		}
		else {
			fornecedores = this.findAll();
		}
		
		return fornecedores;
	}

}
