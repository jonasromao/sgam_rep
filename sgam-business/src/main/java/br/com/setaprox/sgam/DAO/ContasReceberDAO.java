package br.com.setaprox.sgam.DAO;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.ContasReceber;

@Local
public interface ContasReceberDAO {
	
	void persist( ContasReceber contasReceber ) ;
	
	void remove(ContasReceber contasReceber);
	
	void remove(Long id) throws PersistenceException;
	
	void editar( ContasReceber contasReceber );
	
	ContasReceber find( Long id ) ;
	
	List<ContasReceber> findAll();
	
	List<ContasReceber> findAllByCategoria(String nomeCategoria);
	
	List<ContasReceber> findAllByMorador(Long idMorador);
	
	List<ContasReceber> findAllByPeriodo(Date dataInicio, Date dataFim, String categoria);
	
}
