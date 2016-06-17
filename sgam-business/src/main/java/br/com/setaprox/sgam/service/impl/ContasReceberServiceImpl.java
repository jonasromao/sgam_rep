package br.com.setaprox.sgam.service.impl;

import java.util.Date;
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
	public void persist(ContasReceber contaReceber) {
		analistaStatus(contaReceber);
		contasReceberDAO.persist(contaReceber);
	}
	
	@Override
	public void merge(ContasReceber contaReceber) {
		analistaStatus(contaReceber);
		contasReceberDAO.editar(contaReceber);
	}
	
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
	
	private void analistaStatus(ContasReceber contaReceber){
		Date atual = new Date();
		
		if(contaReceber.getDataPagamento() != null){
			contaReceber.setStatus("Recebido");
		}	
		else if(contaReceber.getDataVencimento() != null && contaReceber.getDataVencimento().compareTo(atual) < 0){
			contaReceber.setStatus("Atrasado");
		}
		else{
			contaReceber.setStatus("Pendente");
		}
	}

}
