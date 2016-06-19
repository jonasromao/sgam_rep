package br.com.setaprox.sgam.service.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.DAO.ContasPagarDAO;
import br.com.setaprox.sgam.constante.Status;
import br.com.setaprox.sgam.model.ContasPagar;
import br.com.setaprox.sgam.service.ContasPagarService;

@Stateless
@LocalBean
public class ContasPagarServiceImpl implements ContasPagarService {

	@EJB
	private ContasPagarDAO contasPagarDAO; 
	
	@Override
	public void persist(ContasPagar contaPagar) {
		analistaStatus(contaPagar);
		contasPagarDAO.persist(contaPagar);
	}

	@Override
	public void merge(ContasPagar contaPagar) {
		analistaStatus(contaPagar);
		contasPagarDAO.editar(contaPagar);
	}

	@Override
	public List<ContasPagar> findAll() {
		return contasPagarDAO.findAll();
	}

	@Override
	public ContasPagar find(Long id) {
		return contasPagarDAO.find(id);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		contasPagarDAO.remove(id);
	}
	
	private void analistaStatus(ContasPagar contaPagar){
		Date atual = new Date();
		
		if(contaPagar.getDataPagamento() != null){
			contaPagar.setStatus(Status.PAGA.getCodigo());
		}	
		else if(contaPagar.getDataVencimento() != null && contaPagar.getDataVencimento().compareTo(atual) < 0){
			contaPagar.setStatus(Status.ATRASADA.getCodigo());
		}
		else{
			contaPagar.setStatus(Status.PENDENTE.getCodigo());
		}
	}

	@Override
	public List<ContasPagar> contasVencimentoMensal(Date data) {
		return contasPagarDAO.contasVencimentoMensal(data);
	}

}
