package br.com.setaprox.sgam.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.DAO.ContasReceberDAO;
import br.com.setaprox.sgam.model.ContasReceber;
import br.com.setaprox.sgam.service.ContasReceberService;

@Stateless
@LocalBean
public class ContasReceberServiceImpl implements ContasReceberService {

	@EJB
	private ContasReceberDAO contasReceberDAO; 
	
	@Override
	public List<ContasReceber> findAll() {
		
		return contasReceberDAO.findAll();
		
	}

	@Override
	public ContasReceber find(Long id) {
		
		return contasReceberDAO.find(id);
		
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		
		contasReceberDAO.remove(id);
		
	}
	
	

}
