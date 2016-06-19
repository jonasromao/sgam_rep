package br.com.setaprox.sgam.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.EnderecoDAO;
import br.com.setaprox.sgam.model.Endereco;
import br.com.setaprox.sgam.service.EnderecoService;

@Stateless
@LocalBean
public class EnderecoServiceImpl implements EnderecoService {

	@EJB
	private EnderecoDAO enderecoDAO;
	
	@Override
	public void persist(Endereco endereco) {
		enderecoDAO.persist(endereco);
	}
	
	@Override
	public void remove(Endereco endereco) {
		enderecoDAO.remove(endereco);
	}

	@Override
	public void remove(Long id) {
		enderecoDAO.remove(id);
	}

	@Override
	public void editar(Endereco endereco) {
		enderecoDAO.editar(endereco);
	}

	@Override
	public Endereco find(Long id) {
		return enderecoDAO.find(id);
	}

	@Override
	public List<Endereco> findAll() {
		return enderecoDAO.findAll();
	}
}
