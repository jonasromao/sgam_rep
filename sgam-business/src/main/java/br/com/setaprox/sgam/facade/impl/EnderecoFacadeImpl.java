package br.com.setaprox.sgam.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.setaprox.sgam.facade.EnderecoFacade;
import br.com.setaprox.sgam.model.Endereco;
import br.com.setaprox.sgam.service.EnderecoService;

@Named
@RequestScoped
public class EnderecoFacadeImpl implements EnderecoFacade {

	@EJB
	private EnderecoService enderecoService;
	
	@Override
	public void persist(Endereco endereco) {
		enderecoService.persist(endereco);
	}

	@Override
	public void remove(Endereco endereco) {
		enderecoService.remove(endereco);
	}

	@Override
	public void remove(Long id) {
		enderecoService.remove(id);
	}

	@Override
	public void editar(Endereco endereco) {
		enderecoService.editar(endereco);
	}

	@Override
	public Endereco find(Long id) {
		return enderecoService.find(id);
	}

	@Override
	public List<Endereco> findAll() {
		return enderecoService.findAll();
	}

}
