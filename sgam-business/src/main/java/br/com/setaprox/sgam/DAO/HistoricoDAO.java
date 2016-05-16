package br.com.setaprox.sgam.DAO;

import java.util.List;

import javax.ejb.Local;

import br.com.setaprox.sgam.model.Historico;

@Local
public interface HistoricoDAO {
	
	void persist(Historico historico);
	
	void remove(Historico historico);
	
	Historico getById(Long id);
	
	List<Historico> getAll();
}
