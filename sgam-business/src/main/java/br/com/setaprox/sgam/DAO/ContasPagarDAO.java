package br.com.setaprox.sgam.DAO;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.ContasPagar;

@Local
public interface ContasPagarDAO {
	void persist(ContasPagar contaPagar ) ;
	
	void remove(ContasPagar contaPagar);
	
	void remove(Long id) throws PersistenceException;
	
	void editar(ContasPagar contaPagar);
	
	ContasPagar find( Long id ) ;
	
	List<ContasPagar> findAll();
	
	List<ContasPagar> contasVencimentoMensal(Date data);
	
	List<ContasPagar> findAllByPeriodo(Date dataInicio, Date dataFim, String status);
}
